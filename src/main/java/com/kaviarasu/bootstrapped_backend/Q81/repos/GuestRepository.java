package com.kaviarasu.bootstrapped_backend.Q81.repos;

import com.kaviarasu.bootstrapped_backend.Q81.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest,String> {
    List<Guest> findByFirstNameAndLastName(String firstName, String lastName);
}
