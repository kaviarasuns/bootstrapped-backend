package com.kaviarasu.bootstrapped_backend.Q56.repos;

import com.kaviarasu.bootstrapped_backend.Q56.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}