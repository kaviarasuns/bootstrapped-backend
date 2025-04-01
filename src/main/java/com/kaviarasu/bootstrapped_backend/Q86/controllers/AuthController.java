package com.kaviarasu.bootstrapped_backend.Q86.controllers;


import com.kaviarasu.bootstrapped_backend.Q86.dtos.LoginRequestDto;
import com.kaviarasu.bootstrapped_backend.Q86.dtos.ValidateTokenRequestDto;
import com.kaviarasu.bootstrapped_backend.Q86.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/test/createUser")
    public ResponseEntity<String> createTestUser() {
        return authenticationService.createUser();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
    }

    @PostMapping("/validateToken")
    public Boolean validateToken(@RequestBody ValidateTokenRequestDto validateTokenRequestDto) {
        return authenticationService.validateToken(
                validateTokenRequestDto.getEmail(),
                validateTokenRequestDto.getToken()
        );
    }
}
