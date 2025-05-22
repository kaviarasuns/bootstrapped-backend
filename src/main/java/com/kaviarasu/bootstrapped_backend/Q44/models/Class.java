package com.kaviarasu.bootstrapped_backend.Q44.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "class")
@Data
public class Class {
    @Id
    private UUID id;

    private String topic;

    @ManyToMany(mappedBy = "classes")
    private Set<Batch> batches;

    @ManyToOne
    @JoinColumn(name = "current_instructor_id")
    private Instructor currentInstructor;
}


