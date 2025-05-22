package com.kaviarasu.bootstrapped_backend.Q40.controllers;

import com.kaviarasu.bootstrapped_backend.Q40.dtos.LinkedInSearchRequest;
import com.kaviarasu.bootstrapped_backend.Q40.models.LinkedInSearchItem;
import com.kaviarasu.bootstrapped_backend.Q40.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linkedInSearch")
public class LinkedInSearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping
    public List<LinkedInSearchItem> searchPeople(@RequestBody LinkedInSearchRequest request) {
        return searchService.searchPeople(request);
    }
}
