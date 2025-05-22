package com.kaviarasu.bootstrapped_backend.Q49.services;

import com.kaviarasu.bootstrapped_backend.Q49.dtos.LoginRequest;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.LoginResponse;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.SignupRequest;
import com.kaviarasu.bootstrapped_backend.Q49.dtos.SignupResponse;
import com.kaviarasu.bootstrapped_backend.Q49.exceptions.BadCredentialsException;
import com.kaviarasu.bootstrapped_backend.Q49.exceptions.UserNotSignedUpException;
import com.kaviarasu.bootstrapped_backend.Q49.models.AuthCredential;
import com.kaviarasu.bootstrapped_backend.Q49.models.Session;
import com.kaviarasu.bootstrapped_backend.Q49.models.SessionState;
import com.kaviarasu.bootstrapped_backend.Q49.models.User;
import com.kaviarasu.bootstrapped_backend.Q49.repos.AuthCredentialRepo;
import com.kaviarasu.bootstrapped_backend.Q49.repos.SessionRepo;
import com.kaviarasu.bootstrapped_backend.Q49.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthCredentialRepo authCredentialRepo;

    @Autowired
    private SessionRepo sessionRepo;

    @Override
    public SignupResponse signup(SignupRequest request) {
        // Create AuthCredential
        AuthCredential authCredential = new AuthCredential();
        authCredential.setEmail(request.getEmail());
        authCredential.setPassword(request.getPassword());

        // Create User
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAuthCredential(authCredential);

        // Persist both entities
        authCredentialRepo.save(authCredential);
        userRepo.save(user);

        // Create response
        SignupResponse response = new SignupResponse();
        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());
        response.setEmail(request.getEmail());

        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest)
            throws UserNotSignedUpException, BadCredentialsException {
        // Get credentials by email
        Optional<AuthCredential> optionalAuthCredential =
                authCredentialRepo.findAuthCredentialByEmail(loginRequest.getEmail());

        if (!optionalAuthCredential.isPresent()) {
            throw new UserNotSignedUpException("Please sign up first !!");
        }

        AuthCredential authCredential = optionalAuthCredential.get();

        // Validate password
        if (!authCredential.getPassword().equals(loginRequest.getPassword())) {
            throw new BadCredentialsException("Please provide correct password !!");
        }

        // Find user by credential
        Optional<User> optionalUser = userRepo.findUserByAuthCredential(authCredential);
        User user = optionalUser.get(); // Safe to get as user must exist if credential exists

        // Check for existing active session and remove it using deleteById
        Optional<Session> existingSession = sessionRepo.findSessionByUser(user);
        if (existingSession.isPresent()) {
            sessionRepo.deleteById(existingSession.get().getId());
        }

        // Create new session
        Session session = new Session();
        session.setUser(user);
        session.setToken(getToken());

        // Set TTL to current time + 48 hours (172800000 milliseconds)
        Date ttl = new Date(System.currentTimeMillis() + 172800000);
        session.setTtl(ttl);
        session.setSessionState(SessionState.ACTIVE);

        // Save session
        sessionRepo.save(session);

        // Create response
        LoginResponse response = new LoginResponse();
        response.setUserEmail(loginRequest.getEmail());
        response.setTokenValidity(ttl);
        response.setToken(session.getToken());

        return response;
    }


    private String getToken() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 15) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}

