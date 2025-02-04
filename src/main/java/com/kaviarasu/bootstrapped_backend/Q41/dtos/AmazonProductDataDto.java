package com.kaviarasu.bootstrapped_backend.Q41.dtos;

import com.kaviarasu.bootstrapped_backend.Q41.models.AmazonProduct;
import lombok.Data;

import java.util.List;

@Data
public class AmazonProductDataDto {
    private List<AmazonProduct> products;

    public List<AmazonProduct> getProducts() {
        return products;
    }

    public void setProducts(List<AmazonProduct> products) {
        this.products = products;
    }
}
