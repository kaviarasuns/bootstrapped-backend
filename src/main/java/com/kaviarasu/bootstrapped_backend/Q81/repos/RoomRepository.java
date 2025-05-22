package com.kaviarasu.bootstrapped_backend.Q81.repos;

import com.kaviarasu.bootstrapped_backend.Q81.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
