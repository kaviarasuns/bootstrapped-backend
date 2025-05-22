package com.kaviarasu.bootstrapped_backend.Q50.dtos;

import com.kaviarasu.bootstrapped_backend.Q50.models.Guest;
import com.kaviarasu.bootstrapped_backend.Q50.models.Room;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class BookingResponseDto {
    private Long bookingId;

    private Double totalBill;

    private Guest guest;

    private List<Room> rooms;

    private Date checkInDate;

    private Date checkOutDate;
}
