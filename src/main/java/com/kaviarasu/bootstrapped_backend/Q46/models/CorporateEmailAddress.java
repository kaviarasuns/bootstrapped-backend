package com.kaviarasu.bootstrapped_backend.Q46.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CorporateEmailAddress {

    @Id
    @Column(name = "employee_id")
    private Long id;

    private String tenant;

    private Date createdAt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private CorporateEmployee employee;

    // getters and setters
}