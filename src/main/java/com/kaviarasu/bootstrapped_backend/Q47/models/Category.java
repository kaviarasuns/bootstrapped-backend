package com.kaviarasu.bootstrapped_backend.Q47.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Category {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Product> products = new HashSet<>();
}


