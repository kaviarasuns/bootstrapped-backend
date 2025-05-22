package com.kaviarasu.bootstrapped_backend.Q50.repos;

import com.kaviarasu.bootstrapped_backend.Q50.models.Booking;
import com.kaviarasu.bootstrapped_backend.Q50.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
    List<Booking> findBookingsByGuest(Guest guest);
}
