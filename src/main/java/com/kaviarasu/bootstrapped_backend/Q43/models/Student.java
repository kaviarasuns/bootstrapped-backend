package com.kaviarasu.bootstrapped_backend.Q43.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student")
    private Set<TeacherRating> ratings = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<TeacherRating> getRatings() { return ratings; }
    public void setRatings(Set<TeacherRating> ratings) { this.ratings = ratings; }
}

