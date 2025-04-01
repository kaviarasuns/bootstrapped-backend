package com.kaviarasu.bootstrapped_backend.Q42.models;

import com.kaviarasu.bootstrapped_backend.Q42.models.InstagramComment;
import com.kaviarasu.bootstrapped_backend.Q42.models.InstagramLike;
import com.kaviarasu.bootstrapped_backend.Q42.models.InstagramPage;
import com.kaviarasu.bootstrapped_backend.Q42.models.InstagramPost;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class InstagramUser {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private Set<InstagramPage> pages = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<InstagramLike> instagramLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<InstagramComment> instagramComments = new ArrayList<>();
}
