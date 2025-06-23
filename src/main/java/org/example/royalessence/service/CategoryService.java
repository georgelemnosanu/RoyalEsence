package org.example.royalessence.service;

import org.example.royalessence.models.Category;
import org.example.royalessence.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(Integer id) {
        return categoryRepository.findById(id);
    }


    public Category updateCategory(Category updated) {
        return categoryRepository.save(updated);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
