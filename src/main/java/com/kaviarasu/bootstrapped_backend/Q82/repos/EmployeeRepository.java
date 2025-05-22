package com.kaviarasu.bootstrapped_backend.Q82.repos;


import com.kaviarasu.bootstrapped_backend.Q82.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByDepartment(String department, Pageable pageable);
}
