package com.kaviarasu.bootstrapped_backend.Q41;

import com.kaviarasu.bootstrapped_backend.Q41.models.AmazonProduct;

import java.util.List;

public interface IProductService {
    List<AmazonProduct> getProductByName(String name);
    List<AmazonProduct> getProductByCategoryId(String categoryId);
}
