package com.kaviarasu.bootstrapped_backend.Q55.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOOK")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Book extends Product {

    @Enumerated(EnumType.STRING)
    @Column(name = "book_type", nullable = false)
    private BookType bookType;

    // Custom constructor - explicitly call super constructor
    public Book(String name, Status status, BookType bookType) {
        super(name, status);
        this.bookType = bookType;
    }

    // Constructor with subscription
    public Book(String name, Status status, Subscription subscription, BookType bookType) {
        super(name, status, subscription);
        this.bookType = bookType;
    }

    // All args constructor
    public Book(Long id, String name, Status status, Subscription subscription, BookType bookType) {
        super(id, name, status, subscription);
        this.bookType = bookType;
    }
}

