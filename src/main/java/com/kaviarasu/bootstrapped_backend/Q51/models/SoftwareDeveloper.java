package com.kaviarasu.bootstrapped_backend.Q51.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SOFTWARE_DEVELOPER")
public class SoftwareDeveloper extends PermanentEmployee {
    private Long leavesTaken;
}