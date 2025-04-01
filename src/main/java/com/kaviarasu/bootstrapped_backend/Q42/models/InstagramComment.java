package com.kaviarasu.bootstrapped_backend.Q42.models;

import jakarta.persistence.*;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class InstagramComment {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private InstagramPost post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private InstagramUser user;

    private String text;
}