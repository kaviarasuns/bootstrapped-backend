package com.kaviarasu.bootstrapped_backend.Q42.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class InstagramPost {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "instagram_page_id", nullable = false)
    private InstagramPage instagramPage;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InstagramLike> instagramLikes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InstagramComment> instagramComments;

    @Column(nullable = false)
    private String content;
}