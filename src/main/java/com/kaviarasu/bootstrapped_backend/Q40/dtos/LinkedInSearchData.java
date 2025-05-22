package com.kaviarasu.bootstrapped_backend.Q40.dtos;

import com.kaviarasu.bootstrapped_backend.Q40.models.LinkedInSearchItem;
import lombok.Data;

import java.util.List;

@Data
public class LinkedInSearchData {
    private List<LinkedInSearchItem> items;
}

