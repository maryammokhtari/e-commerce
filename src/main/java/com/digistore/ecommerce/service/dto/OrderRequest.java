package com.digistore.ecommerce.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long userId;
    private Map<Long,Integer> products;
}
