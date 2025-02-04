package com.kaviarasu.bootstrapped_backend.Q41;

import com.kaviarasu.bootstrapped_backend.Q41.dtos.AmazonProductDto;
import com.kaviarasu.bootstrapped_backend.Q41.models.AmazonProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import org.springframework.http.HttpHeaders;
import java.util.Collections;
import java.util.List;

@Service
public class AmazonProductService implements IProductService {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    private static final String RAPID_API_HOST = "real-time-amazon-data.p.rapidapi.com";
    private static final String BASE_URL = "https://real-time-amazon-data.p.rapidapi.com";
    private static final String rapidApiKey = "b73a2f70c7mshc62f7563456f547p17ce47jsn74a8b4084a5f";


    @Override
    public List<AmazonProduct> getProductByName(String name) {
        String url = BASE_URL + "/search?query=" + name;
        HttpHeaders headers = createHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<AmazonProductDto> response = restTemplateBuilder.build().exchange(
                url,
                HttpMethod.GET,
                entity,
                AmazonProductDto.class
        );

        return response.getBody() != null && response.getBody().getData() != null
                ? response.getBody().getData().getProducts()
                : Collections.emptyList();
    }

    public List<AmazonProduct> getProductByCategoryId(String categoryId) {
        String url = BASE_URL + "/products-by-category?category_id=" + categoryId;
        HttpHeaders headers = createHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<AmazonProductDto> response = restTemplateBuilder.build().exchange(
                url,
                HttpMethod.GET,
                entity,
                AmazonProductDto.class
        );

        return response.getBody() != null && response.getBody().getData() != null
                ? response.getBody().getData().getProducts()
                : Collections.emptyList();
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", RAPID_API_HOST);
        return headers;
    }
}
