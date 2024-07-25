package com.digistore.ecommerce.service.mapper;

import com.digistore.ecommerce.repository.entity.User;
import com.digistore.ecommerce.service.dto.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "orders",ignore = true)
    User userRequestToUser(UserRequest userRequest);
}
