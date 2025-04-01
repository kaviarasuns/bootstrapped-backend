package com.kaviarasu.bootstrapped_backend.Q86.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ValidateTokenRequestDto {
    String email;
    String token;
}
