package com.digistore.ecommerce.controller;

import com.digistore.ecommerce.repository.entity.Category;
import com.digistore.ecommerce.service.CategoryService;
import com.digistore.ecommerce.service.dto.CategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping({"/id"})
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Category> Create(@RequestBody @Valid CategoryRequest categoryRequest){
       return ResponseEntity.ok(categoryService.create(categoryRequest));
    }
    @DeleteMapping({"/id"})
    public ResponseEntity deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping({"/id"})
    public ResponseEntity<Category> update(@PathVariable Long id ,@RequestBody @Valid CategoryRequest categoryRequest){
        Category updatedCategory= categoryService.update(id,categoryRequest);
        return ResponseEntity.ok(updatedCategory);
    }
}
