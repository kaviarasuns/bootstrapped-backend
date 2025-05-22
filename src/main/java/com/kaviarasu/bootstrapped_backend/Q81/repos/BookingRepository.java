package com.kaviarasu.bootstrapped_backend.Q81.repos;

import com.kaviarasu.bootstrapped_backend.Q81.models.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    Page<Booking> findByGuest_EmailId(String emailId, Pageable pageable);
    List<Booking> findByGuest_EmailIdOrderByDateAsc(String emailId);
    Page<Booking> findByDate(Date date, Pageable pageable);
    Page<Booking> findByRooms_IdAndDate(Long roomId, Date date, Pageable pageable);
}
