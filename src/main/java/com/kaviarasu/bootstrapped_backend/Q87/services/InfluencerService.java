package com.kaviarasu.bootstrapped_backend.Q87.services;

import com.kaviarasu.bootstrapped_backend.Q87.models.Influencer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class InfluencerService {

    private static final long MIN_FOLLOWERS_NEEDED_TO_VIRAL = 500000;
    private static final long MIN_TOTAL_POST_REACH = 5000000;
    private static final String VIRAL_INFLUENCER_REDIS_KEY  = "influencer";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Adds an influencer to the Redis cache if they meet the viral criteria
     * @param influencer The influencer to potentially add to the cache
     * @return true if the influencer was added to the cache, false otherwise
     */
    public Boolean addInfluencerToCache(Influencer influencer) {
        // Check if the influencer meets the viral criteria
        if (isViral(influencer)) {
            // Store the influencer in Redis using hash operations
            redisTemplate.opsForHash().put(
                    VIRAL_INFLUENCER_REDIS_KEY,
                    influencer.getId(),
                    influencer
            );
            return true;
        }
        return false;
    }

    /**
     * Retrieves all viral influencers from the Redis cache
     * @return List of all viral influencers
     */
    public List<Influencer> getAllViralInfluencers() {
        // Get all values from the hash
        List<Object> values = redisTemplate.opsForHash().values(VIRAL_INFLUENCER_REDIS_KEY);

        // Convert values to a list of Influencer objects
        List<Influencer> influencers = new ArrayList<>();
        for (Object value : values) {
            if (value instanceof Influencer) {
                influencers.add((Influencer) value);
            }
        }

        return influencers;
    }

    /**
     * Retrieves the details of a specific influencer from the Redis cache
     * @param id The ID of the influencer to retrieve
     * @return The influencer if found in the cache, null otherwise
     */
    public Influencer getInfluencerDetails(Long id) {
        // Get the influencer from Redis using hash operations
        Object influencerObj = redisTemplate.opsForHash().get(VIRAL_INFLUENCER_REDIS_KEY, id);

        if (influencerObj != null) {
            return (Influencer) influencerObj;
        }

        return null;
    }

    /**
     * Determines if an influencer meets the viral criteria
     * @param influencer The influencer to check
     * @return true if the influencer meets the viral criteria, false otherwise
     */
    private boolean isViral(Influencer influencer) {
        return influencer.getFollowers() > MIN_FOLLOWERS_NEEDED_TO_VIRAL ||
                influencer.getTotalPostReach() > MIN_TOTAL_POST_REACH;
    }
}