package com.kaviarasu.bootstrapped_backend.Q51.models;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Employee {
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;
}
