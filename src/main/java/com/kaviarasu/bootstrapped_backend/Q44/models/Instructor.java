package com.kaviarasu.bootstrapped_backend.Q44.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Instructor {
    @Id
    private UUID id;

    @ManyToMany(mappedBy = "instructors")
    private Set<Batch> batches = new HashSet<>();

    private String name;

    private String email;
}


