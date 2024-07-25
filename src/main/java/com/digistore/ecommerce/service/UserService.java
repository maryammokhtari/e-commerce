package com.digistore.ecommerce.service;

import com.digistore.ecommerce.exception.ResourceNotFoundException;
import com.digistore.ecommerce.repository.UserRepository;
import com.digistore.ecommerce.repository.entity.User;
import com.digistore.ecommerce.service.dto.UserRequest;
import com.digistore.ecommerce.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    public static final String USER_IS_NOT_FOUND = "User is not exist.";
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ResourceNotFoundException(USER_IS_NOT_FOUND);
    }

    public User create(UserRequest userRequest) {
        User user = userMapper.userRequestToUser(userRequest);
        return userRepository.save(user);
    }

    public User update(Long id, UserRequest userRequest) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(USER_IS_NOT_FOUND);
        }
        User user = userMapper.userRequestToUser(userRequest);
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(USER_IS_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }
}
