package com.kaviarasu.bootstrapped_backend.Q49.services;

import com.kaviarasu.bootstrapped_backend.Q49.dtos.LoginRequest;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.LoginResponse;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.SignupRequest;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.SignupResponse;
import com.kaviarasu.bootstrapped_backend.Q49.exceptions.BadCredentialsException;
import com.kaviarasu.bootstrapped_backend.Q49.exceptions.UserNotSignedUpException;

public interface IAuthService {
    SignupResponse signup(SignupRequest request);

    LoginResponse login(LoginRequest loginRequest) throws UserNotSignedUpException, BadCredentialsException;
}
