package com.kaviarasu.bootstrapped_backend.Q44.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Learner {
    @Id
    private UUID id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "current_batch_id")
    private Batch currentBatch;

    @ManyToMany
    @JoinTable(
            name = "learners_previous_batches",
            joinColumns = @JoinColumn(name = "learner_id"),
            inverseJoinColumns = @JoinColumn(name = "previous_batch_id")
    )
    private Set<Batch> previousBatches = new HashSet<>();
}

