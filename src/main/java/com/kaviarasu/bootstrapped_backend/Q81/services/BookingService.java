package com.kaviarasu.bootstrapped_backend.Q81.services;

import com.kaviarasu.bootstrapped_backend.Q81.models.Booking;
import com.kaviarasu.bootstrapped_backend.Q81.models.Guest;
import com.kaviarasu.bootstrapped_backend.Q81.repos.BookingRepository;
import com.kaviarasu.bootstrapped_backend.Q81.repos.GuestRepository;
import com.kaviarasu.bootstrapped_backend.Q81.repos.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Page<Booking> getAllBookingDoneByGuest(String guestEmail, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber != null ? pageNumber : 0, pageSize != null ? pageSize : 10);
        return bookingRepository.findByGuest_EmailId(guestEmail, pageable);
    }

    public Page<Booking> getAllBookingsOnDateWhenMayorIsStaying(
            String firstName, String lastName, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber != null ? pageNumber : 0, pageSize != null ? pageSize : 10);
        List<Guest> guests = guestRepository.findByFirstNameAndLastName(firstName, lastName);
        if (guests == null || guests.isEmpty()) {
            return Page.empty(pageable);
        }
        Guest mayor = guests.get(0);
        List<Booking> mayorBookings = bookingRepository.findByGuest_EmailIdOrderByDateAsc(mayor.getEmailId());
        if (mayorBookings == null || mayorBookings.isEmpty()) {
            return Page.empty(pageable);
        }
        Date mayorBookingDate = mayorBookings.get(0).getDate();
        return bookingRepository.findByDate(mayorBookingDate, pageable);
    }

    public Page<Booking> getAllBookingsDoneForRoomOnParticularDate(
            Long roomNumber, Date date, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber != null ? pageNumber : 0, pageSize != null ? pageSize : 10);
        return bookingRepository.findByRooms_IdAndDate(roomNumber, date, pageable);
    }
}