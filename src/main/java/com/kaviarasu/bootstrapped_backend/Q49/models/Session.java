package com.kaviarasu.bootstrapped_backend.Q49.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "USER_LOGIN_SESSIONS")
@Data
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String token;
    private Date ttl;
    private SessionState sessionState;
}




