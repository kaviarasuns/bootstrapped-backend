package com.kaviarasu.bootstrapped_backend.Q50.repos;

import com.kaviarasu.bootstrapped_backend.Q50.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepo extends JpaRepository<Guest,String> {
    Optional<Guest> findByEmail(String email);
}
