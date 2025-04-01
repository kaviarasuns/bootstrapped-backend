package com.kaviarasu.bootstrapped_backend.Q41;

import com.kaviarasu.bootstrapped_backend.Q41.models.AmazonProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/amazon")
public class AmazonProductController {

    @Autowired
    private IProductService amazonProductService;

    @GetMapping("/search")
    public List<AmazonProduct> searchAmazonProduct(
            @RequestParam("query") String searchQuery) {
        return amazonProductService.getProductByName(searchQuery);
    }

    @GetMapping("/products-by-category")
    public List<AmazonProduct> getProductsByCategory(
            @RequestParam("categoryid") String categoryId) {
        return amazonProductService.getProductByCategoryId(categoryId);
    }
}
