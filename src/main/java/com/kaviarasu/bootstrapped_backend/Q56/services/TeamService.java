package com.kaviarasu.bootstrapped_backend.Q56.services;

import com.kaviarasu.bootstrapped_backend.Q56.models.Team;
import com.kaviarasu.bootstrapped_backend.Q56.repos.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    public Team getTeamDetails(UUID teamId) {
        return teamRepo.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));
    }
}
