package com.kaviarasu.bootstrapped_backend.Q48.repos;

import com.kaviarasu.bootstrapped_backend.Q48.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryById(Long id);
    List<Category> findCategoryByName(String name);
    List<Category> findCategoryByIdBetween(Long id1, Long id2);
    List<Category> findCategoryByIsPremiumTrue();
}


