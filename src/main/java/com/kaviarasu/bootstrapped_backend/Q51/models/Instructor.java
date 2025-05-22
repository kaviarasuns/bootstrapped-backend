package com.kaviarasu.bootstrapped_backend.Q51.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "INSTRUCTOR")
public class Instructor extends ContractualEmployee {
    private String company;
}

