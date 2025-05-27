package com.kaviarasu.bootstrapped_backend.Q56.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class IdentityProof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
