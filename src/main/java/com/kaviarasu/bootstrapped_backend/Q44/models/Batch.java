package com.kaviarasu.bootstrapped_backend.Q44.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Batch {
    @Id
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "instructors_batches",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private List<Instructor> instructors;

    private String name;

    @OneToMany(mappedBy = "currentBatch")
    private Set<Learner> learners = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "batches_classes",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<Class> classes;
}


