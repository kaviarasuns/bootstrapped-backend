package com.kaviarasu.bootstrapped_backend.Q84.services;

import com.kaviarasu.bootstrapped_backend.Q84.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String PRODUCT_IN_DEMAND = "iphone";
    private final String REDIS_KEY_POPULAR_PRODUCT = "iphone_related";
    private final String REDIS_KEY_NORMAL_PRODUCT = "products";

    /**
     * Retrieves popular products with priority for iPhone-related items
     */
    public Set<Product> getPopularProducts() {
        Set<Object> productIds = redisTemplate.opsForSet().members(REDIS_KEY_POPULAR_PRODUCT);
        Set<Product> products = new HashSet<>();

        if (productIds != null && !productIds.isEmpty()) {
            // Retrieve each popular product by ID from the hash
            for (Object productId : productIds) {
                Object product = redisTemplate.opsForHash().get(REDIS_KEY_NORMAL_PRODUCT, productId.toString());
                if (product instanceof Product) {
                    products.add((Product) product);
                }
            }
            return products;
        } else {
            // If no popular products, return all products
            Map<Object, Object> allProducts = redisTemplate.opsForHash().entries(REDIS_KEY_NORMAL_PRODUCT);
            for (Object product : allProducts.values()) {
                if (product instanceof Product) {
                    products.add((Product) product);
                }
            }
            return products;
        }
    }

    /**
     * Adds a product to Redis cache
     * - Product stored in Hash with key being product ID
     * - For popular products, store product ID in Set for faster lookup
     */
    public Product addProduct(Product product) {
        // Generate ID if not present
        if (product.getId() == null) {
            product.setId(System.currentTimeMillis());
        }

        // Store product in hash
        redisTemplate.opsForHash().put(REDIS_KEY_NORMAL_PRODUCT, product.getId().toString(), product);

        // Check if product is iPhone related (popular)
        if (isPopularProduct(product)) {
            // Store product ID in set for fast retrieval
            redisTemplate.opsForSet().add(REDIS_KEY_POPULAR_PRODUCT, product.getId());
        }

        return product;
    }

    /**
     * Determines if a product is considered popular
     */
    private boolean isPopularProduct(Product product) {
        String title = product.getTitle() != null ? product.getTitle().toLowerCase() : "";
        String description = product.getDescription() != null ? product.getDescription().toLowerCase() : "";
        String category = product.getCategory() != null ? product.getCategory().toLowerCase() : "";

        return title.contains(PRODUCT_IN_DEMAND) ||
                description.contains(PRODUCT_IN_DEMAND) ||
                category.contains(PRODUCT_IN_DEMAND);
    }


}
