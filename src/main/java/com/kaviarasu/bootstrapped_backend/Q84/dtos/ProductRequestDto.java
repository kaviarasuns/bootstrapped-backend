package com.kaviarasu.bootstrapped_backend.Q84.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestDto {
    private String title;
    private String description;
    private String category;
    private String imageUrl;
    private Double price;
}
