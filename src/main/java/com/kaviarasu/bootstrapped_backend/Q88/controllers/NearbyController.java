package com.kaviarasu.bootstrapped_backend.Q88.controllers;

import com.kaviarasu.bootstrapped_backend.Q88.dtos.UserLocationDto;
import com.kaviarasu.bootstrapped_backend.Q88.models.Restaurant;
import com.kaviarasu.bootstrapped_backend.Q88.services.NearbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nearby/restaurants")
public class NearbyController {

    @Autowired
    private NearbyService nearbyService;

    @PostMapping("/add")
    public ResponseEntity<Boolean> addRestaurant(@RequestBody Restaurant restaurant) {
        Boolean result = nearbyService.addLocation(restaurant);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<List<Restaurant>> getNearbyRestaurants(@RequestBody UserLocationDto userLocationDto) {
        List<Restaurant> restaurants = nearbyService.findNearbyLocations(
                userLocationDto.getLatitude(),
                userLocationDto.getLongitude(),
                userLocationDto.getRadius()
        );
        return ResponseEntity.ok(restaurants);
    }
}
