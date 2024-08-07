package com.digistore.ecommerce.service;

import com.digistore.ecommerce.exception.ResourceNotFoundException;
import com.digistore.ecommerce.repository.CategoryRepository;
import com.digistore.ecommerce.repository.entity.Category;
import com.digistore.ecommerce.service.dto.CategoryRequest;
import com.digistore.ecommerce.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    public static final String CATEGORY_IS_NOT_EXIST = "Category is not exist.";
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new ResourceNotFoundException(CATEGORY_IS_NOT_EXIST);
    }

    public Category create(CategoryRequest categoryRequest) {
        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        return categoryRepository.save(category);
    }

    public Category update(Long id, CategoryRequest categoryRequest) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException(CATEGORY_IS_NOT_EXIST);
        }
        Category category = categoryMapper.categoryUpdateRequestToCategory(categoryRequest,id);
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException(CATEGORY_IS_NOT_EXIST);
        }
        categoryRepository.deleteById(id);
    }
}
