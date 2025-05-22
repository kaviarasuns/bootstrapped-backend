package com.kaviarasu.bootstrapped_backend.Q81.controllers;

import com.kaviarasu.bootstrapped_backend.Q81.dtos.BookingSearchDto;
import com.kaviarasu.bootstrapped_backend.Q81.models.Booking;
import com.kaviarasu.bootstrapped_backend.Q81.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    //Add your APIs here.
    @PostMapping("/bookings/guestEmail")
    public Page<Booking> getBookingsByGuestEmail(@RequestBody BookingSearchDto dto) {
        return bookingService.getAllBookingDoneByGuest(
                dto.getGuestEmail(),
                dto.getPageNumber(),
                dto.getPageSize()
        );
    }

    @PostMapping("/bookings/guestName")
    public Page<Booking> getBookingsOnDateWhenMayorIsStaying(@RequestBody BookingSearchDto dto) {
        return bookingService.getAllBookingsOnDateWhenMayorIsStaying(
                dto.getGuestFirstName(),
                dto.getGuestLastName(),
                dto.getPageNumber(),
                dto.getPageSize()
        );
    }

    @PostMapping("/bookings/roomNumber_date")
    public Page<Booking> getBookingsForRoomOnDate(@RequestBody BookingSearchDto dto) {
        return bookingService.getAllBookingsDoneForRoomOnParticularDate(
                dto.getRoomNumber(),
                dto.getBookingDate(),
                dto.getPageNumber(),
                dto.getPageSize()
        );
    }
}
