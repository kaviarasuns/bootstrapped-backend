package com.kaviarasu.bootstrapped_backend.Q54.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BLOG_POST")
public class BlogPost extends Publication {

    private String url;

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}