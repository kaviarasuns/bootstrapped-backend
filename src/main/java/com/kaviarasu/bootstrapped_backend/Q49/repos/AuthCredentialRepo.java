package com.kaviarasu.bootstrapped_backend.Q49.repos;

import com.kaviarasu.bootstrapped_backend.Q49.models.AuthCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthCredentialRepo extends JpaRepository<AuthCredential,String> {
    Optional<AuthCredential> findAuthCredentialByEmail(String email);
}
