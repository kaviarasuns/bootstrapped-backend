package com.kaviarasu.bootstrapped_backend.Q86.services;


import com.kaviarasu.bootstrapped_backend.Q86.models.User;
import com.kaviarasu.bootstrapped_backend.Q86.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

@Service
public class AuthenticationService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SecretKey secretKey;

    @Autowired
    private UserRepo userRepo;

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public ResponseEntity<String> createUser(){
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password123");
        userRepo.save(user);
        return ResponseEntity.ok("Test user created");
    }

    public ResponseEntity<Boolean> login(String email, String password) {
        // Check if user exists in DB
        Optional<User> userOptional = userRepo.findUserByEmail(email);

        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

        User user = userOptional.get();

        // Validate password
        if (!user.getPassword().equals(password)) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }

        // Generate JWT token
        long now = System.currentTimeMillis();
        long expiryTime = now + 3600000; // 1 hour expiry

        String token = Jwts.builder()
                .claim("user", email)
                .issuedAt(new Date(now))
                .expiration(new Date(expiryTime))
                .signWith(secretKey)
                .compact();

        // Store token in Redis
        redisTemplate.opsForValue().set(email, token);

        // Return response with token in header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return new ResponseEntity<>(true, headers, HttpStatus.OK);
    }

    public Boolean validateToken(String email, String token) {
        // Get token from Redis
        String storedToken = (String) redisTemplate.opsForValue().get(email);

        if (storedToken == null) {
            throw new RuntimeException("Authentication Error !!");
        }

        try {
            // Parse token and validate
            Jws<Claims> claimsJws = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(storedToken);

            Claims claims = claimsJws.getPayload();
            Date expiration = claims.getExpiration();

            // Check if token is expired
            return !expiration.before(new Date());

        } catch (Exception e) {
            return false;
        }
    }
}

