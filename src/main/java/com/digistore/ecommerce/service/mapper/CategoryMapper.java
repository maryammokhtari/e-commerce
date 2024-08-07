package com.digistore.ecommerce.service.mapper;

import com.digistore.ecommerce.repository.entity.Category;
import com.digistore.ecommerce.service.dto.CategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category categoryRequestToCategory(CategoryRequest categoryRequest);

    @Mapping(target = "id",source = "id")
    Category categoryUpdateRequestToCategory(CategoryRequest categoryRequest, Long id);
}
