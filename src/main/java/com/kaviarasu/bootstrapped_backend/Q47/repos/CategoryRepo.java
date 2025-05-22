package com.kaviarasu.bootstrapped_backend.Q47.repos;

import com.kaviarasu.bootstrapped_backend.Q47.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
