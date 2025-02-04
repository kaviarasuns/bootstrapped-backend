package com.kaviarasu.bootstrapped_backend.Q41.dtos;

import com.kaviarasu.bootstrapped_backend.Q41.models.AmazonProduct;
import lombok.Data;

import java.util.List;

@Data
public class AmazonProductDto {
    private AmazonProductDataDto data;

    public AmazonProductDataDto getData() {
        return data;
    }

    public void setData(AmazonProductDataDto data) {
        this.data = data;
    }
}
