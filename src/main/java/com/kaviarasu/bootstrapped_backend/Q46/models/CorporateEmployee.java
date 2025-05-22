package com.kaviarasu.bootstrapped_backend.Q46.models;

import jakarta.persistence.*;

@Entity
public class CorporateEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String designation;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CorporateEmailAddress emailAddress;

    // getters and setters
}