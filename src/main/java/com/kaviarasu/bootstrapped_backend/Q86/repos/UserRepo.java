package com.kaviarasu.bootstrapped_backend.Q86.repos;


import com.kaviarasu.bootstrapped_backend.Q86.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}

