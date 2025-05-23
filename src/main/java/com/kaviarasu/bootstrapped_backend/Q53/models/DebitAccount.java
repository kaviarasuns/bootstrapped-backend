package com.kaviarasu.bootstrapped_backend.Q53.models;

import jakarta.persistence.*;

@Entity
public class DebitAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne(mappedBy = "debit", cascade = CascadeType.ALL)
    private DebitCard debitCard;

    // Getters and setters
}


