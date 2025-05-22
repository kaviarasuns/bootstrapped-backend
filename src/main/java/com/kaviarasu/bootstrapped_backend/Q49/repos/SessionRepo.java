package com.kaviarasu.bootstrapped_backend.Q49.repos;


import com.kaviarasu.bootstrapped_backend.Q49.models.Session;
import com.kaviarasu.bootstrapped_backend.Q49.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {
    Optional<Session> findSessionByUser(User user);
}
