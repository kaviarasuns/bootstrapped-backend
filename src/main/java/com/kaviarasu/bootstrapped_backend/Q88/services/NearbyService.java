package com.kaviarasu.bootstrapped_backend.Q88.services;

import com.kaviarasu.bootstrapped_backend.Q88.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NearbyService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String LOCATION_KEY = "nearby_restaurants";
    private static final String RESTAURANT_INFO_KEY = "restaurant_info";

    public Boolean addLocation(Restaurant restaurant) {
        try {
            // Store restaurant details in a hash
            Long restaurantId = restaurant.getId();
            redisTemplate.opsForHash().put(RESTAURANT_INFO_KEY, restaurantId, restaurant);

            // Add geo information - passing the ID as Long, not String
            Point point = new Point(restaurant.getLongitude(), restaurant.getLatitude());
            redisTemplate.opsForGeo().add(LOCATION_KEY, point, restaurantId);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Restaurant> findNearbyLocations(double userLatitude, double userLongitude, double radius) {
        try {
            // Create a circle around user's location with given radius
            Circle circle = new Circle(
                    new Point(userLongitude, userLatitude),
                    new Distance(radius, RedisGeoCommands.DistanceUnit.KILOMETERS)
            );

            // Find members within circle
            GeoResults<RedisGeoCommands.GeoLocation<Object>> geoResults =
                    redisTemplate.opsForGeo().radius(LOCATION_KEY, circle);

            List<Restaurant> nearbyRestaurants = new ArrayList<>();

            if (geoResults != null && !geoResults.getContent().isEmpty()) {
                // Get restaurant IDs from geo results
                List<Object> restaurantIds = new ArrayList<>();
                geoResults.forEach(geoResult -> {
                    restaurantIds.add(geoResult.getContent().getName());
                });

                // Get restaurant details for each ID
                if (!restaurantIds.isEmpty()) {
                    List<Object> restaurantList = redisTemplate.opsForHash()
                            .multiGet(RESTAURANT_INFO_KEY, restaurantIds);

                    for (Object obj : restaurantList) {
                        if (obj instanceof Restaurant) {
                            nearbyRestaurants.add((Restaurant) obj);
                        }
                    }
                }
            }

            return nearbyRestaurants;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
