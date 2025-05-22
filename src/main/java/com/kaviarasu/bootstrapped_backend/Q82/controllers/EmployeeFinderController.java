package com.kaviarasu.bootstrapped_backend.Q82.controllers;

import com.kaviarasu.bootstrapped_backend.Q82.dtos.EmployeeFinderRequestDto;
import com.kaviarasu.bootstrapped_backend.Q82.models.Employee;
import com.kaviarasu.bootstrapped_backend.Q82.services.EmployeeFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class EmployeeFinderController {

    @Autowired
    private EmployeeFinderService employeeFinderService;

    @PostMapping("/employeeFinder")
    public Page<Employee> findEmployees(@RequestBody EmployeeFinderRequestDto requestDto) {
        return employeeFinderService.findEmployees(
                requestDto.getDepartment(),
                requestDto.getPageNumber(),
                requestDto.getPageSize(),
                requestDto.getSortParamList()
        );
    }
}
