package com.kaviarasu.bootstrapped_backend.Q53.models;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "credit_account_id")
    private CreditAccount credit;

    // Getters and setters
}

