package com.kaviarasu.bootstrapped_backend.Q55.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column(nullable = false)
    protected String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Status status;

    // Many-to-One relationship with Subscription
    // Product belongs to a Subscription
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id", nullable = true)
    @ToString.Exclude
    protected Subscription subscription;

    // Custom constructor for name and status (without id and subscription)
    public Product(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    // Custom constructor with subscription
    public Product(String name, Status status, Subscription subscription) {
        this.name = name;
        this.status = status;
        this.subscription = subscription;
    }
}
