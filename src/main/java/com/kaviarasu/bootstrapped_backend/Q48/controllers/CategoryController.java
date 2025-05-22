package com.kaviarasu.bootstrapped_backend.Q48.controllers;

import com.kaviarasu.bootstrapped_backend.Q48.models.Category;
import com.kaviarasu.bootstrapped_backend.Q48.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/premium")
    public ResponseEntity<List<Category>> getPremiumCategories() {
        List<Category> premiumCategories = categoryService.getAllPremiumCategories();
        return ResponseEntity.ok(premiumCategories);
    }

    @GetMapping("/{categoryId1}/{categoryId2}")
    public ResponseEntity<List<Category>> getCategoriesBetweenIds(
            @PathVariable Long categoryId1,
            @PathVariable Long categoryId2) {
        List<Category> categories = categoryService.getCategoriesBetweenIds(
                categoryId1,
                categoryId2
        );
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Category>> getCategoriesWithMatchingName(
            @PathVariable String categoryName) {
        List<Category> categories = categoryService.getCategoriesWithMatchingName(
                categoryName
        );
        return ResponseEntity.ok(categories);
    }
}


