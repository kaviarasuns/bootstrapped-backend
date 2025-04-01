package com.kaviarasu.bootstrapped_backend.Q87.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddInfluencerDto {
    private String name;

    private Long followers;

    private Long totalPostReach;

    private String displayPictureUrl;

    private Long totalPosts;

    private String bio;
}
