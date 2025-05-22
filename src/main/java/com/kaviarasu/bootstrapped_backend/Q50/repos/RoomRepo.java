package com.kaviarasu.bootstrapped_backend.Q50.repos;

import com.kaviarasu.bootstrapped_backend.Q50.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room,Long> {
}
