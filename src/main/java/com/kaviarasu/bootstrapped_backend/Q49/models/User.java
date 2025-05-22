package com.kaviarasu.bootstrapped_backend.Q49.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTH_CREDENTIAL_EMAIL", referencedColumnName = "email")
    private AuthCredential authCredential;

}


