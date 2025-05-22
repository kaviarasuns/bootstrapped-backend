package com.kaviarasu.bootstrapped_backend.Q48.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isPremium;
}
