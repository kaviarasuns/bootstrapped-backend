package com.kaviarasu.bootstrapped_backend.Q87.controllers;

import com.kaviarasu.bootstrapped_backend.Q87.dtos.AddInfluencerDto;
import com.kaviarasu.bootstrapped_backend.Q87.models.Influencer;
import com.kaviarasu.bootstrapped_backend.Q87.services.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencer")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    @PostMapping
    public ResponseEntity<Boolean> addInfluencer(@RequestBody AddInfluencerDto influencerDto) {
        Influencer influencer = new Influencer();
        influencer.setName(influencerDto.getName());
        influencer.setFollowers(influencerDto.getFollowers());
        influencer.setTotalPostReach(influencerDto.getTotalPostReach());
        influencer.setDisplayPictureUrl(influencerDto.getDisplayPictureUrl());
        influencer.setTotalPosts(influencerDto.getTotalPosts());
        influencer.setBio(influencerDto.getBio());
        influencer.setId(System.currentTimeMillis()); // Simple ID generation, replace with your preferred method

        Boolean result = influencerService.addInfluencerToCache(influencer);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAllViralInfluencers() {
        List<Influencer> influencers = influencerService.getAllViralInfluencers();
        return ResponseEntity.ok(influencers);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Influencer> getInfluencerById(@PathVariable Long id) {
        Influencer influencer = influencerService.getInfluencerDetails(id);
        if (influencer != null) {
            return ResponseEntity.ok(influencer);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
