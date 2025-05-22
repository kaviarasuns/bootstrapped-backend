package com.kaviarasu.bootstrapped_backend.Q48.services;

import org.jetbrains.annotations.NotNull;
import com.kaviarasu.bootstrapped_backend.Q48.models.Category;
import com.kaviarasu.bootstrapped_backend.Q48.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageCategoryService implements ICategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category addCategory(@NotNull Category category) {
        Optional<Category> existingCategory = categoryRepo.findCategoryById(category.getId());
        if (existingCategory.isPresent()) {
            return existingCategory.get();
        }
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllPremiumCategories() {
        return categoryRepo.findCategoryByIsPremiumTrue();
    }

    @Override
    public List<Category> getCategoriesBetweenIds(Long categoryId1, Long categoryId2) {
        return categoryRepo.findCategoryByIdBetween(categoryId1, categoryId2);
    }

    @Override
    public List<Category> getCategoriesWithMatchingName(String categoryName) {
        return categoryRepo.findCategoryByName(categoryName);
    }
}

