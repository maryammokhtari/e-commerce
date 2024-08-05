package com.digistore.ecommerce.service;

import com.digistore.ecommerce.exception.ResourceNotFoundException;
import com.digistore.ecommerce.repository.ProductRepository;
import com.digistore.ecommerce.repository.entity.Product;
import com.digistore.ecommerce.service.dto.ProductRequest;
import com.digistore.ecommerce.service.mapper.ProductMapper;
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
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    @Mock
    ProductMapper productMapper;
    @InjectMocks
    ProductService productService;

    Product product;
    ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        product = Product.builder().id(1L).price(2.0).name("cucumber").description("green fruit").build();
        productRequest = ProductRequest.builder().price(2.0).name("cucumber").description("green fruit").build();
    }

    @Test
    void testCreateProduct() {
        when(productMapper.productRequestToProduct(productRequest)).thenReturn(product);
        productService.create(productRequest);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testDeleteProduct() {
        when(productRepository.existsById(product.getId())).thenReturn(true);
        productService.deleteById(product.getId());
        verify(productRepository, times(1)).deleteById(product.getId());
    }

    @Test
    void testDeleteProduct_ThrowsException() {
        when(productRepository.existsById(product.getId())).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> {
            productService.deleteById(product.getId());
        });
        verify(productRepository, times(0)).deleteById(product.getId());
    }

    @Test
    void updateProduct() {
        when(productMapper.productUpdateRequestToProduct(productRequest, product.getId())).thenReturn(product);
        when(productRepository.existsById(product.getId())).thenReturn(true);
        productService.update(product.getId(), productRequest);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void updateProduct_ThrowsException() {
        when(productRepository.existsById(product.getId())).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> {
            productService.update(product.getId(), productRequest);
        });
        verify(productRepository, times(0)).save(product);
    }

    @Test
    void getAllProduct() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(2l, "apple", "red fruit", null, 1.5, null, null);
        Product product2 = new Product(3l, "yoghurt", "greek model", null, 3.5, null, null);
        productList.add(product1);
        productList.add(product2);

        when(productRepository.findAll()).thenReturn(productList);
        List<Product> products = productService.findAll();
        assertEquals(2, products.size());
        verify(productRepository).findAll();
    }

    @Test
    void getById() {
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Product result = productService.findById(product.getId());
        assertEquals(result.getName(), product.getName());
        verify(productRepository).findById(product.getId());
    }
}
