package com.digistore.ecommerce.service.mapper;

import com.digistore.ecommerce.repository.entity.Category;
import com.digistore.ecommerce.service.dto.CategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category categoryRequestToCategory(CategoryRequest categoryRequest);

}
