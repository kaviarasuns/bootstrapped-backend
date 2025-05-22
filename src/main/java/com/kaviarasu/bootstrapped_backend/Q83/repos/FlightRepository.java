package com.kaviarasu.bootstrapped_backend.Q83.repos;

import com.kaviarasu.bootstrapped_backend.Q83.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {
}
