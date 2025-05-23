package com.kaviarasu.bootstrapped_backend.Q53.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CreditAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double interestRate;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private Set<CreditCard> creditCard = new HashSet<>();

    // Getters and setters
}


