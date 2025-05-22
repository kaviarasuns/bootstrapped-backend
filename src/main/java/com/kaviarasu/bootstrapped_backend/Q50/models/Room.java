package com.kaviarasu.bootstrapped_backend.Q50.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private Double rent;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}


