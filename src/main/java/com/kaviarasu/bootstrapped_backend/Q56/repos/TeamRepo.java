package com.kaviarasu.bootstrapped_backend.Q56.repos;

import com.kaviarasu.bootstrapped_backend.Q56.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamRepo extends JpaRepository<Team, UUID> {
}
