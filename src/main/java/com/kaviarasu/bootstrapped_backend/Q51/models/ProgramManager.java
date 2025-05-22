package com.kaviarasu.bootstrapped_backend.Q51.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROGRAM_MANAGER")
public class ProgramManager extends PermanentEmployee {
    private Long featuresCompleted;
}