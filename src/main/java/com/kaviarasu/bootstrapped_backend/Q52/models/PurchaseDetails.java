package com.kaviarasu.bootstrapped_backend.Q52.models;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name = "PAYMENT_TYPE")
public abstract class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String owner;

    // Getters and setters
}
