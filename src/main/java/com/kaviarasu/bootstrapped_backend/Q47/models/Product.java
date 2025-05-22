package com.kaviarasu.bootstrapped_backend.Q47.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    private Long id;

    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Category category;

    private String description;

    private String imageUrl;

    private Double price;

    private Date createdAt;
}

