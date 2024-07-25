package com.digistore.ecommerce.service.dto;

import com.digistore.ecommerce.repository.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String imageUrl;
    @NotNull
    @Min(value = 0, message = "The price must be a positive value")
    private BigDecimal price;
    @NotBlank
    private Category category;
}
