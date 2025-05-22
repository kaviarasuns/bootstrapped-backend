package com.kaviarasu.bootstrapped_backend.Q49.repos;

import com.kaviarasu.bootstrapped_backend.Q49.models.AuthCredential;
import com.kaviarasu.bootstrapped_backend.Q49.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByAuthCredential(AuthCredential authCredential);
}
