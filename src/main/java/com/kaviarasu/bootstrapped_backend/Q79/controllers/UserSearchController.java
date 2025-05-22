package com.kaviarasu.bootstrapped_backend.Q79.controllers;

import com.kaviarasu.bootstrapped_backend.Q79.dtos.UserSearchRequestDto;
import com.kaviarasu.bootstrapped_backend.Q79.models.User;
import com.kaviarasu.bootstrapped_backend.Q79.services.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserSearchController {

    @Autowired
    private UserSearchService userSearchService;

    @PostMapping("/search")
    public List<User> searchUsersByAddress(@RequestBody UserSearchRequestDto requestDto) {
        return userSearchService.getUsersHavingAddress(
                requestDto.getQuery(),
                requestDto.getPageNumber()
        );
    }

    @GetMapping("/search/ladies")
    public List<User> searchLadies(@RequestParam(required = false) Integer pageNumber) {
        return userSearchService.getDetailsOfAllLadies(pageNumber);
    }

    @GetMapping("/search/adultMales")
    public List<User> searchAdultMales(@RequestParam(required = false) Integer pageNumber) {
        return userSearchService.getDetailsOfAllAdultMales(pageNumber);
    }
}
