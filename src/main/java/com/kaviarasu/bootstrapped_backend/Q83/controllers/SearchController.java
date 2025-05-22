package com.kaviarasu.bootstrapped_backend.Q83.controllers;

import com.kaviarasu.bootstrapped_backend.Q83.models.Flight;
import com.kaviarasu.bootstrapped_backend.Q83.services.OpenSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public class SearchController {

    @Autowired
    private OpenSearchService openSearchService;

    @GetMapping("/search/{query}")
    public Page<Flight> searchFlights(@PathVariable String query,
                                      @RequestParam(defaultValue = "0") Integer pageNumber,
                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        return openSearchService.getFlightsMatchingSearchQuery(query, pageSize, pageNumber);
    }
}
