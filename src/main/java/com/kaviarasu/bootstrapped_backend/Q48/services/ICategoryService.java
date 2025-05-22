package com.kaviarasu.bootstrapped_backend.Q48.services;


import com.kaviarasu.bootstrapped_backend.Q48.models.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);

    List<Category> getAllPremiumCategories();

    List<Category> getCategoriesBetweenIds(Long categoryId1,Long categoryId2);

    List<Category> getCategoriesWithMatchingName(String categoryName);
}

