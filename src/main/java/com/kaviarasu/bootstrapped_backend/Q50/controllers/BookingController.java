package com.kaviarasu.bootstrapped_backend.Q50.controllers;

import com.kaviarasu.bootstrapped_backend.Q50.dtos.BookingRequestDto;
import com.kaviarasu.bootstrapped_backend.Q50.dtos.BookingResponseDto;
import com.kaviarasu.bootstrapped_backend.Q50.services.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/booking/guest/{guestEmail}")
    public List<BookingResponseDto> getAllBookingsPerGuest(@PathVariable String guestEmail) {
        return bookingService.getAllBookingsPerGuest(guestEmail);
    }

    @GetMapping("/booking/{bookingId}")
    public BookingResponseDto getBooking(@PathVariable Long bookingId) {
        return bookingService.getBooking(bookingId);
    }

    @PostMapping("/booking")
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.createBooking(bookingRequestDto);
    }

    @PutMapping("/booking/{bookingId}")
    public BookingResponseDto replaceBooking(@PathVariable Long bookingId, @RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.replaceBooking(bookingId, bookingRequestDto);
    }

    @DeleteMapping("/booking/{bookingId}")
    public Boolean deleteBooking(@PathVariable Long bookingId) {
        return bookingService.deleteBooking(bookingId);
    }
}


