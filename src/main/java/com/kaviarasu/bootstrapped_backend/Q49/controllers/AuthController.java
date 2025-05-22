package com.kaviarasu.bootstrapped_backend.Q49.controllers;

import com.kaviarasu.bootstrapped_backend.Q49.dtos.LoginRequest;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.LoginResponse;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.SignupRequest;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.SignupResponse;
import com.kaviarasu.bootstrapped_backend.Q49.exceptions.BadCredentialsException;
import com.kaviarasu.bootstrapped_backend.Q49.exceptions.UserNotSignedUpException;
import com.kaviarasu.bootstrapped_backend.Q49.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/auth/signup")
    public SignupResponse signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request)
            throws UserNotSignedUpException, BadCredentialsException {
        return authService.login(request);
    }
}


