package com.kaviarasu.bootstrapped_backend.Q49.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AUTH_CREDENTIALS")
@Data
public class AuthCredential {
    @Id
    private String email;

    private String password;

    // Remove the user field to avoid circular mapping issues
    // If you must keep it, make sure it's marked as @JsonIgnore or similar
    // @OneToOne(mappedBy = "authCredential")
    // private User user;
}

