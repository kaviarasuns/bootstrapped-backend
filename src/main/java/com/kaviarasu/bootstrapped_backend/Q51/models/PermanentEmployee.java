package com.kaviarasu.bootstrapped_backend.Q51.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PERMANENT_EMPLOYEE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PermanentEmployee extends Employee {
    @Id
    private String email;

    private Double costToCompany;
}

