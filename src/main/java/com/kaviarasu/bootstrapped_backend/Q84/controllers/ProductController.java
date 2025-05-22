package com.kaviarasu.bootstrapped_backend.Q84.controllers;

import com.kaviarasu.bootstrapped_backend.Q84.dtos.ProductRequestDto;
import com.kaviarasu.bootstrapped_backend.Q84.models.Product;
import com.kaviarasu.bootstrapped_backend.Q84.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setCategory(productRequestDto.getCategory());
        product.setImageUrl(productRequestDto.getImageUrl());
        product.setPrice(productRequestDto.getPrice());

        return productService.addProduct(product);
    }

    @GetMapping
    public Set<Product> getProducts() {
        return productService.getPopularProducts();
    }
}
