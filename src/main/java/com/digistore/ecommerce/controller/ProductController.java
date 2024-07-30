package com.digistore.ecommerce.controller;

import com.digistore.ecommerce.repository.entity.Product;
import com.digistore.ecommerce.service.ProductService;
import com.digistore.ecommerce.service.dto.ProductRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok( productService.findAll());
    }
    @GetMapping({"/id"})
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(productService.create(productRequest));
    }
    @DeleteMapping({"/id"})
    public ResponseEntity deleteById(@PathVariable Long id){
       productService.deleteById(id);
       return ResponseEntity.ok().build();
    }
    @PutMapping({"/id"})
    public ResponseEntity<Product> update(@PathVariable Long id , @RequestBody ProductRequest productRequest){
        Product updatedProduct= productService.update(id ,productRequest);
        return ResponseEntity.ok(updatedProduct);
    }
}
