package com.kaviarasu.bootstrapped_backend.Q79.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSearchRequestDto {
    private String query;
    private Integer pageNumber;
}
