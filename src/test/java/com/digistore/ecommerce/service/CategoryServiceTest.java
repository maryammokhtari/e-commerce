package com.digistore.ecommerce.service;

import com.digistore.ecommerce.exception.ResourceNotFoundException;
import com.digistore.ecommerce.repository.CategoryRepository;
import com.digistore.ecommerce.repository.entity.Category;
import com.digistore.ecommerce.service.dto.CategoryRequest;
import com.digistore.ecommerce.service.mapper.CategoryMapper;
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
public class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;
    @Mock
    CategoryMapper categoryMapper;
    @InjectMocks
    CategoryService categoryService;

    Category category;
    CategoryRequest categoryRequest;


    @BeforeEach
    void setUp() {
        category = Category.builder().id(1L).name("vegetables").build();
        categoryRequest = CategoryRequest.builder().name("vegetables").build();
    }

    @Test
    void testCreateCategory() {
        when(categoryMapper.categoryRequestToCategory(categoryRequest)).thenReturn(category);
        categoryService.create(categoryRequest);
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testDeleteProduct() {
        when(categoryRepository.existsById(category.getId())).thenReturn(true);
        categoryService.deleteById(category.getId());
        verify(categoryRepository).deleteById(category.getId());
    }

    @Test
    void testDelete_ThrowsException() {
        when(categoryRepository.existsById(category.getId())).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> {
            categoryService.deleteById(category.getId());
        });
        verify(categoryRepository, times(0)).deleteById(category.getId());
    }

    @Test
    void testUpdateCategory() {
        when(categoryRepository.existsById(category.getId())).thenReturn(true);
        when(categoryMapper.categoryUpdateRequestToCategory(categoryRequest, category.getId())).thenReturn(category);
        categoryService.update(category.getId(), categoryRequest);
        verify(categoryRepository).save(category);
    }

    @Test
    void testUpdateCategory_ThrowsException() {
        when(categoryRepository.existsById(category.getId())).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> {
            categoryService.update(category.getId(), categoryRequest);
        });
        verify(categoryRepository, times(0)).save(category);
    }

    @Test
    void testFindAllCategory() {
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("dairies").id(2L).build();
        Category category2 = Category.builder().name("Bakery").id(3L).build();
        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        when(categoryRepository.findAll()).thenReturn(categories);
        List<Category> result = categoryService.findAll();
        assertEquals(3, result.size());
        verify(categoryRepository).findAll();
    }

    @Test
    void testFindCategoryById() {
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        Category resultCategory = categoryService.findById(category.getId());
        assertEquals(resultCategory.getName(), category.getName());
        verify(categoryRepository).findById(category.getId());
    }

    @Test
    void testFindCategoryById_ThrowsException() {
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> categoryService.findById(category.getId()));
    }
}
