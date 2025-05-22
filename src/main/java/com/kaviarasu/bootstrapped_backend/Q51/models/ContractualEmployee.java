package com.kaviarasu.bootstrapped_backend.Q51.models;


import jakarta.persistence.*;

@Entity
@Table(name = "CONTRACTUAL_EMPLOYEE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ContractualEmployee extends Employee {
    @Id
    private String alias;

    private Double hourlyRenumeration;
}
