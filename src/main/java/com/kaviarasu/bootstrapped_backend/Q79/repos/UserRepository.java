package com.kaviarasu.bootstrapped_backend.Q79.repos;

import com.kaviarasu.bootstrapped_backend.Q79.models.Sex;
import com.kaviarasu.bootstrapped_backend.Q79.models.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE LOWER(u.address) LIKE LOWER(CONCAT('%', :address, '%'))")
    List<User> findByAddressContaining(
            @Param("address") String address,
            Pageable pageable
    );

    @Query("SELECT u FROM User u WHERE u.sex = :sex")
    List<User> findBySex(
            @Param("sex") Sex sex,
            Pageable pageable
    );

    @Query("SELECT u FROM User u WHERE u.sex = :sex AND u.age >= :minAge")
    List<User> findBySexAndAgeGreaterThanEqual(
            @Param("sex") Sex sex,
            @Param("minAge") Integer minAge,
            Pageable pageable
    );
}

