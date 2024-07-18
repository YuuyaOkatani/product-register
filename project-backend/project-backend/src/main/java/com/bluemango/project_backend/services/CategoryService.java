package com.bluemango.project_backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bluemango.project_backend.dto.CategoryRequest;
import com.bluemango.project_backend.dto.CategoryResponse;
import com.bluemango.project_backend.models.Category;
import com.bluemango.project_backend.repositories.CategoryRepository;
import com.bluemango.project_backend.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public CategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return category.toDTO();

    }

    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> c.toDTO())
                .collect(Collectors.toList());
    }

    public CategoryResponse save(CategoryRequest categoryRequest) {
        Category category = categoryRepository.save(categoryRequest.toEntity());
        return category.toDTO();
    }

    public void deleteById(int id) {
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Constrain violation, category can't be deleted");

        } catch (EmptyResultDataAccessException e) {
            throw new DatabaseException("Category not found");

        }

    }

    public void update(int id, CategoryRequest category) {
        try {
            Category existingCategory = categoryRepository.getReferenceById(id);
            existingCategory.setName(category.getName());
            categoryRepository.save(existingCategory);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Category not found");
        }
    }

}
