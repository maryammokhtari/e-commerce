package com.digistore.ecommerce.service;

import com.digistore.ecommerce.exception.ResourceNotFoundException;
import com.digistore.ecommerce.repository.UserRepository;
import com.digistore.ecommerce.repository.entity.UserInfo;
import com.digistore.ecommerce.service.dto.UserRequest;
import com.digistore.ecommerce.service.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserMapper userMapper;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    UserInfo userInfo;
    UserRequest userRequest;

    @BeforeEach
    void setUp() {
        userInfo = UserInfo.builder().id(1L).username("Maryam").password("maryam").email("maryam.mokhtari.f@gmail.com").role("user").build();
        userRequest = UserRequest.builder().username("Maryam").password("maryam").email("maryam.mokhtari.f@gmail.com").role("user").build();
    }

    @Test
    void testCreateUser() {
        when(userMapper.userRequestToUser(userRequest)).thenReturn(userInfo);
        userService.create(userRequest);
        verify(userRepository, times(1)).save(userInfo);
    }

    @Test
    void TestDeleteUser() {
        when(userRepository.existsById(userInfo.getId())).thenReturn(true);
        userService.deleteById(userInfo.getId());
        verify(userRepository, times(1)).deleteById(userInfo.getId());
    }

    @Test
    void testDeleteUser_ThrowsException() {
        when(userRepository.existsById(userInfo.getId())).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> {
            userService.deleteById(userInfo.getId());
        });
    }

    @Test
    void testUpdateUser() {
        when(userRepository.existsById(userInfo.getId())).thenReturn(true);
        when(userMapper.userUpdateRequestToUser(userRequest, userInfo.getId())).thenReturn(userInfo);
        userService.update(userInfo.getId(), userRequest);
        verify(userRepository).save(userInfo);
    }

    @Test
    void testUpdateUser_ThrowsException() {
        when(userRepository.existsById(userInfo.getId())).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> userService.update(userInfo.getId(), userRequest));
        verify(userRepository, times(0)).save(userInfo);
    }

    @Test
    void testFindAllUser() {
        List<UserInfo> users = new ArrayList<>();
        UserInfo userInfo1 = UserInfo.builder().id(2L).username("Hamed").password("hamed").email("hamed@gmail.com").role("admin").build();
        UserInfo userInfo2 = UserInfo.builder().id(3L).username("zara").password("zara").email("zara@gmail.com").role("admin").build();
        users.add(userInfo1);
        users.add(userInfo2);
        when(userRepository.findAll()).thenReturn(users);
        List<UserInfo> result = userService.findAll();
        assertEquals(2, users.size());
        verify(userRepository).findAll();
    }

    @Test
    void testFindUserById() {
        when(userRepository.findById(userInfo.getId())).thenReturn(Optional.of(userInfo));
        UserInfo userInfo1 = userService.findById(userInfo.getId());
        assertEquals(userInfo.getUsername(), userInfo1.getUsername());
        verify(userRepository).findById(userInfo.getId());
    }

    @Test
    void testFindUserById_ThrowsException() {
        when(userRepository.findById(userInfo.getId())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userService.findById(userInfo.getId()));
    }
}
