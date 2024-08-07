package com.digistore.ecommerce.service.mapper;

import com.digistore.ecommerce.repository.entity.UserInfo;
import com.digistore.ecommerce.service.dto.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserInfo userRequestToUser(UserRequest userRequest);

    @Mapping(target="id",source = "id")
    UserInfo userUpdateRequestToUser(UserRequest userRequest,Long id);
}
