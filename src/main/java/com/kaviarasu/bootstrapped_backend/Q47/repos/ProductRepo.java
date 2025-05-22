package com.kaviarasu.bootstrapped_backend.Q47.repos;

import com.kaviarasu.bootstrapped_backend.Q47.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    // Get Products with particular Name
    List<Product> findByName(String name);

    // Delete Products with specific Name and return count
    @Modifying
    @Query("DELETE FROM Product p WHERE p.name = ?1")
    Long deleteByName(String name);

    // Delete Products with specific Category Name
    @Modifying
    @Query("DELETE FROM Product p WHERE p.category.name = ?1")
    void deleteByCategoryName(String categoryName);

    // Delete Product if it's id matches with provided Category id
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id = p.category.id AND p.category.id = ?1")
    void deleteProductWhereIdMatchesCategoryId(Long categoryId);

    // Retain Products created after certain Date
    @Modifying
    @Query("DELETE FROM Product p WHERE p.createdAt < ?1")
    int retainProductsAfter(Date retainDate);  // Changed to int as per test case
}



