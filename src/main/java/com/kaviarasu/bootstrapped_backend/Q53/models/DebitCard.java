package com.kaviarasu.bootstrapped_backend.Q53.models;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
public class DebitCard {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "debit_account_id")
    private DebitAccount debit;

    // Getters and setters
}


