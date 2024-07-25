package com.digistore.ecommerce.service.mapper;

import com.digistore.ecommerce.repository.entity.Product;
import com.digistore.ecommerce.service.dto.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    Product productRequestToProduct(ProductRequest productRequest);
}
