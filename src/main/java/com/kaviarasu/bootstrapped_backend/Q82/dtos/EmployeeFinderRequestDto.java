package com.kaviarasu.bootstrapped_backend.Q82.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class EmployeeFinderRequestDto {
    private String department;
    private Integer pageNumber;
    private Integer pageSize;
    List<SortParam> sortParamList = new ArrayList<>();
}
