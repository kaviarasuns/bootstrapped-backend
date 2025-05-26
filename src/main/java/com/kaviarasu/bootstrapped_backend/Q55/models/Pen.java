package com.kaviarasu.bootstrapped_backend.Q55.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PEN")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Pen extends Product {

    @Enumerated(EnumType.STRING)
    @Column(name = "pen_type", nullable = false)
    private PenType penType;

    // Custom constructor - explicitly call super constructor
    public Pen(String name, Status status, PenType penType) {
        super(name, status);
        this.penType = penType;
    }

    // Constructor with subscription
    public Pen(String name, Status status, Subscription subscription, PenType penType) {
        super(name, status, subscription);
        this.penType = penType;
    }

    // All args constructor
    public Pen(Long id, String name, Status status, Subscription subscription, PenType penType) {
        super(id, name, status, subscription);
        this.penType = penType;
    }
}
