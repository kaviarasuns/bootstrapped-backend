package com.kaviarasu.bootstrapped_backend.Q50.services;

import com.kaviarasu.bootstrapped_backend.Q50.dtos.BookingRequestDto;
import com.kaviarasu.bootstrapped_backend.Q50.dtos.BookingResponseDto;

import java.util.List;

public interface IBookingService {
    BookingResponseDto getBooking(Long bookingId);

    List<BookingResponseDto> getAllBookingsPerGuest(String guestEmail);

    BookingResponseDto replaceBooking(Long bookingId, BookingRequestDto bookingRequestDto);

    BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);

    Boolean deleteBooking(Long bookingId);
}
