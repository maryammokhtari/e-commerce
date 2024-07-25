package com.digistore.ecommerce.service.mapper;

import com.digistore.ecommerce.repository.entity.User;
import com.digistore.ecommerce.service.dto.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User userRequestToUser(UserRequest userRequest);
}
