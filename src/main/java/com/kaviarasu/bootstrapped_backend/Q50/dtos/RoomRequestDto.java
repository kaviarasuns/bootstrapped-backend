package com.kaviarasu.bootstrapped_backend.Q50.dtos;

import com.kaviarasu.bootstrapped_backend.Q50.models.RoomType;
import lombok.Data;


@Data
public class RoomRequestDto {
    RoomType roomType;
    int roomCount;
}
