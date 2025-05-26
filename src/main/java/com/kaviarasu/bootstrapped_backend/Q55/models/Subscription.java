package com.kaviarasu.bootstrapped_backend.Q55.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SUBSCRIPTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected double charges;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Status status;

    // Custom constructor without id
    public Subscription(double charges, Status status) {
        this.charges = charges;
        this.status = status;
    }
}