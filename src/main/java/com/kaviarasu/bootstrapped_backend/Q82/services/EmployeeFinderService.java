package com.kaviarasu.bootstrapped_backend.Q82.services;

import com.kaviarasu.bootstrapped_backend.Q82.dtos.SortParam;
import com.kaviarasu.bootstrapped_backend.Q82.dtos.SortType;
import com.kaviarasu.bootstrapped_backend.Q82.models.Employee;
import com.kaviarasu.bootstrapped_backend.Q82.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeFinderService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> findEmployees(String department, Integer pageNumber, Integer pageSize, List<SortParam> sortParams) {
        // Build Sort object
        Sort sort = Sort.unsorted();
        if (sortParams != null && !sortParams.isEmpty()) {
            List<Sort.Order> orders = new ArrayList<>();
            for (SortParam param : sortParams) {
                Sort.Direction direction = param.getSortType() == SortType.ASC
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC;
                orders.add(new Sort.Order(direction, param.getParamName()));
            }
            sort = Sort.by(orders);
        }

        // PageRequest (pageNumber is 0-based)
        PageRequest pageRequest = PageRequest.of(
                pageNumber != null ? pageNumber : 0,
                pageSize != null ? pageSize : 10,
                sort
        );

        // Query by department
        return employeeRepository.findByDepartment(department, pageRequest);
    }
}
