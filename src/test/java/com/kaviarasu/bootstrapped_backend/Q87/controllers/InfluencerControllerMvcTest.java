package com.kaviarasu.bootstrapped_backend.Q87.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.kaviarasu.bootstrapped_backend.Q87.dtos.AddInfluencerDto;
import com.kaviarasu.bootstrapped_backend.Q87.models.Influencer;
import com.kaviarasu.bootstrapped_backend.Q87.services.InfluencerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InfluencerController.class)
public class InfluencerControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private InfluencerService influencerService;

    @MockitoBean
    private RedisTemplate<String, Object> redisTemplate;

    @MockitoBean
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    public void testAddInfluencer() throws Exception {
        AddInfluencerDto addInfluencerDto = new AddInfluencerDto();
        addInfluencerDto.setName("John Doe");
        addInfluencerDto.setFollowers(30000L);
        addInfluencerDto.setTotalPostReach(150000L);
        addInfluencerDto.setDisplayPictureUrl("http://example.com/johndoe.jpg");
        addInfluencerDto.setTotalPosts(50L);
        addInfluencerDto.setBio("Lifestyle influencer");

        when(influencerService.addInfluencerToCache(any())).thenReturn(true);

        mockMvc.perform(post("/influencer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addInfluencerDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(influencerService, times(1)).addInfluencerToCache(any());
    }

    @Test
    public void testGetAllViralInfluencers() throws Exception {
        Influencer influencer1 = new Influencer();
        influencer1.setId(1L);
        influencer1.setName("John Doe");

        Influencer influencer2 = new Influencer();
        influencer2.setId(2L);
        influencer2.setName("Jane Smith");

        List<Influencer> influencers = Arrays.asList(influencer1, influencer2);

        when(influencerService.getAllViralInfluencers()).thenReturn(influencers);

        mockMvc.perform(get("/influencer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));

        verify(influencerService, times(1)).getAllViralInfluencers();
    }

    @Test
    public void testGetInfluencer() throws Exception {
        Influencer influencer = new Influencer();
        influencer.setId(1L);
        influencer.setName("John Doe");

        when(influencerService.getInfluencerDetails(1L)).thenReturn(influencer);

        mockMvc.perform(get("/influencer/id/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        verify(influencerService, times(1)).getInfluencerDetails(1L);
    }

    @Test
    public void testGetInfluencerNotFound() throws Exception {
        when(influencerService.getInfluencerDetails(1L)).thenReturn(null);

        mockMvc.perform(get("/influencer/id/{id}", 1L))
                .andExpect(status().isNotFound());

        verify(influencerService, times(1)).getInfluencerDetails(1L);
    }
}
