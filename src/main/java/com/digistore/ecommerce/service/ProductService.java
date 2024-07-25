package com.digistore.ecommerce.service;

import com.digistore.ecommerce.exception.ResourceNotFoundException;
import com.digistore.ecommerce.repository.ProductRepository;
import com.digistore.ecommerce.repository.entity.Product;
import com.digistore.ecommerce.service.dto.ProductRequest;
import com.digistore.ecommerce.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    public static final String PRODUCT_IS_NOT_EXIST = "Product is not exist.";
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(Long id){
        Optional<Product>product =productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        }
        throw new ResourceNotFoundException(PRODUCT_IS_NOT_EXIST);
    }
    public Product create(ProductRequest productRequest){
        Product product= productMapper.productRequestToProduct(productRequest);
        return productRepository.save(product);
    }
    public Product update(Long id,ProductRequest productRequest){
    if (!productRepository.existsById(id)){
        throw new ResourceNotFoundException(PRODUCT_IS_NOT_EXIST);
    }
    Product product=productMapper.productRequestToProduct(productRequest);
    return productRepository.save(product);
    }
    public void deleteById(Long id){
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException(PRODUCT_IS_NOT_EXIST);
        }
        productRepository.deleteById(id);
    }
}
