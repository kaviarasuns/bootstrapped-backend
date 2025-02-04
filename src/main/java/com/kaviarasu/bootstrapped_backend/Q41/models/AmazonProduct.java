package com.kaviarasu.bootstrapped_backend.Q41.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmazonProduct {
    private String product_title;
    private String product_price;
    private String product_photo;
    private Boolean is_prime;
    private String asin;
}

