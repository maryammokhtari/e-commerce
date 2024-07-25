package com.digistore.ecommerce.service.mapper;

import com.digistore.ecommerce.repository.entity.Product;
import com.digistore.ecommerce.service.dto.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "orders",ignore = true)
    Product productRequestToProduct(ProductRequest productRequest);
}
