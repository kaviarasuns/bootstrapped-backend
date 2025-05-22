package com.kaviarasu.bootstrapped_backend.Q83.services;

import com.kaviarasu.bootstrapped_backend.Q83.models.Flight;
import com.kaviarasu.bootstrapped_backend.Q83.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenSearchService {

    @Autowired
    private FlightRepository flightRepository;


    public Page<Flight> getFlightsMatchingSearchQuery(String query, Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Flight> allFlights = flightRepository.findAll();
        List<Flight> matchedFlights = new ArrayList<>();

        String lowerQuery = query.toLowerCase().trim();

        Time searchedTime = null;
        try {
            searchedTime = Time.valueOf(lowerQuery);
        } catch (IllegalArgumentException e) {
            // not a time
        }

        for (Flight flight : allFlights) {
            boolean matched = false;

            if (flight.getFlightId() != null && flight.getFlightId().toLowerCase().contains(lowerQuery)) matched = true;
            else if (flight.getAirlinesName() != null && flight.getAirlinesName().toLowerCase().contains(lowerQuery)) matched = true;
            else if (flight.getSource() != null && flight.getSource().toLowerCase().contains(lowerQuery)) matched = true;
            else if (flight.getDestination() != null && flight.getDestination().toLowerCase().contains(lowerQuery)) matched = true;
            else if (flight.getStop() != null && flight.getStop().toLowerCase().contains(lowerQuery)) matched = true;
            else if (flight.getCaptainName() != null && flight.getCaptainName().toLowerCase().contains(lowerQuery)) matched = true;
            else if (flight.getSize() != null && flight.getSize().name().toLowerCase().contains(lowerQuery)) matched = true;
            else if (flight.getSeatsOccupied() != null && flight.getSeatsOccupied().toString().contains(lowerQuery)) matched = true;
            else if (flight.getSeatsVacant() != null && flight.getSeatsVacant().toString().contains(lowerQuery)) matched = true;
            else if (searchedTime != null && flight.getTime() != null) {
                long diff = Math.abs(flight.getTime().toLocalTime().toSecondOfDay() - searchedTime.toLocalTime().toSecondOfDay());
                if (diff <= 3 * 60 * 60) matched = true;
            }

            if (matched) {
                matchedFlights.add(flight);
            }
        }

        int start = Math.min(pageNumber * pageSize, matchedFlights.size());
        int end = Math.min(start + pageSize, matchedFlights.size());

        List<Flight> pagedFlights = (start >= end) ? new ArrayList<>() : matchedFlights.subList(start, end);
        return new PageImpl<>(pagedFlights, pageable, matchedFlights.size());
    }

}

