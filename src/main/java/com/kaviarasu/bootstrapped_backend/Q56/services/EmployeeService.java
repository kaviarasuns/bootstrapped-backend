package com.kaviarasu.bootstrapped_backend.Q56.services;

import com.kaviarasu.bootstrapped_backend.Q56.models.Employee;
import com.kaviarasu.bootstrapped_backend.Q56.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee getEmployeeDetails(Long empId) {
        return employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
    }
}
