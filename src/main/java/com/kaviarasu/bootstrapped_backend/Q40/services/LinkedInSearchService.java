package com.kaviarasu.bootstrapped_backend.Q40.services;

import com.kaviarasu.bootstrapped_backend.Q40.dtos.LinkedInSearchRequest;
import com.kaviarasu.bootstrapped_backend.Q40.dtos.LinkedInSearchResult;
import com.kaviarasu.bootstrapped_backend.Q40.models.LinkedInSearchItem;
import com.kaviarasu.bootstrapped_backend.Q40.util.HeaderRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LinkedInSearchService implements ISearchService {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    private static final String API_URL = "https://linkedin-data-api.p.rapidapi.com/search-people-by-url";
    private static final String RAPIDAPI_KEY = "YOUR_X_RAPIDAPI_KEY"; // <-- Replace with your key

    @Override
    public List<LinkedInSearchItem> searchPeople(LinkedInSearchRequest linkedInSearchRequest) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("X-RapidAPI-Key", RAPIDAPI_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LinkedInSearchRequest> entity = new HttpEntity<>(linkedInSearchRequest, headers);

        ResponseEntity<LinkedInSearchResult> response = null;
        try {
            response = restTemplate.postForEntity(
                    API_URL,
                    entity,
                    LinkedInSearchResult.class
            );
        } catch (Exception e) {
            // Optionally log the error
            return Collections.emptyList();
        }

        if (response != null && response.getBody() != null && response.getBody().getData() != null) {
            return response.getBody().getData().getItems();
        }
        return Collections.emptyList();
    }

}
