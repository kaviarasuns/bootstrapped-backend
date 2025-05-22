package com.kaviarasu.bootstrapped_backend.Q50.services;

import com.kaviarasu.bootstrapped_backend.Q50.dtos.BookingRequestDto;
import com.kaviarasu.bootstrapped_backend.Q50.dtos.BookingResponseDto;
import com.kaviarasu.bootstrapped_backend.Q50.dtos.RoomRequestDto;
import com.kaviarasu.bootstrapped_backend.Q50.models.Booking;
import com.kaviarasu.bootstrapped_backend.Q50.models.Guest;
import com.kaviarasu.bootstrapped_backend.Q50.models.Room;
import com.kaviarasu.bootstrapped_backend.Q50.models.RoomType;
import com.kaviarasu.bootstrapped_backend.Q50.repos.BookingRepo;
import com.kaviarasu.bootstrapped_backend.Q50.repos.GuestRepo;
import com.kaviarasu.bootstrapped_backend.Q50.repos.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StorageBookingService implements IBookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private GuestRepo guestRepo;

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public BookingResponseDto getBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepo.findById(bookingId);
        return bookingOpt.map(this::from).orElse(null);
    }

    @Override
    public List<BookingResponseDto> getAllBookingsPerGuest(String guestEmail) {
        Optional<Guest> guestOpt = guestRepo.findByEmail(guestEmail);
        if (!guestOpt.isPresent()) return new ArrayList<>();
        List<Booking> bookings = bookingRepo.findBookingsByGuest(guestOpt.get());
        return bookings.stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        // Find or create guest
        Guest guest = guestRepo.findByEmail(bookingRequestDto.getCustomerEmail())
                .orElse(null);

        if (guest == null) {
            guest = new Guest();
            guest.setEmail(bookingRequestDto.getCustomerEmail());
            guest.setName(bookingRequestDto.getCustomerName());
            guestRepo.save(guest);
        }

        Booking booking = new Booking();
        booking.setGuest(guest);
        booking.setCheckInDate(from(bookingRequestDto.getCheckInDate()));
        booking.setCheckOutDate(from(bookingRequestDto.getCheckOutDate()));

        List<Room> rooms = new ArrayList<>();
        double totalBill = 0.0;
        int days = getDays(booking.getCheckInDate(), booking.getCheckOutDate());

        for (RoomRequestDto roomRequestDto : bookingRequestDto.getRoomRequestDtos()) {
            Room room = new Room();
            room.setRoomType(roomRequestDto.getRoomType());
            double rent = 0.0;
            if(roomRequestDto.getRoomType().equals(RoomType.DELUXE)) {
                rent = 1000D;
            } else if(roomRequestDto.getRoomType().equals(RoomType.SUPER_DELUXE)) {
                rent = 1500D;
            } else if(roomRequestDto.getRoomType().equals(RoomType.SUITE)) {
                rent = 2500D;
            }
            rent = rent * roomRequestDto.getRoomCount();
            room.setRent(rent);
            room.setBooking(booking);
            rooms.add(room);
            totalBill += rent * days;
        }
        booking.setRooms(rooms);
        booking.setTotalBill(totalBill);

        bookingRepo.save(booking);
        for (Room r : rooms) {
            roomRepo.save(r);
        }

        BookingResponseDto responseDto = new BookingResponseDto();
        responseDto.setBookingId(booking.getId());
        responseDto.setRooms(rooms);
        responseDto.setGuest(guest);
        responseDto.setTotalBill(totalBill);
        responseDto.setCheckInDate(booking.getCheckInDate());
        responseDto.setCheckOutDate(booking.getCheckOutDate());
        return responseDto;
    }

    @Override
    public BookingResponseDto replaceBooking(Long bookingId, BookingRequestDto bookingRequestDto) {
        Optional<Booking> bookingOpt = bookingRepo.findById(bookingId);
        if (!bookingOpt.isPresent()) return null;
        bookingRepo.deleteById(bookingId);
        return createBooking(bookingRequestDto);
    }

    @Override
    public Boolean deleteBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepo.findById(bookingId);
        if (!bookingOpt.isPresent()) return false;
        bookingRepo.deleteById(bookingId);
        return true;
    }

    private int getDays(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        int days = (int) (diff / (1000 * 60 * 60 * 24));
        return days == 0 ? 1 : days;
    }

    private BookingResponseDto from(Booking booking) {
        if (booking == null) return null;
        BookingResponseDto responseDto = new BookingResponseDto();
        responseDto.setBookingId(booking.getId());
        responseDto.setRooms(booking.getRooms());
        responseDto.setGuest(booking.getGuest());
        responseDto.setTotalBill(booking.getTotalBill());
        responseDto.setCheckOutDate(booking.getCheckOutDate());
        responseDto.setCheckInDate(booking.getCheckInDate());
        return responseDto;
    }

    private Date from(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(date);
        }catch (ParseException exception) {
            return null;
        }
    }
}
