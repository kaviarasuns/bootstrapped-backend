package com.kaviarasu.bootstrapped_backend.Q40.services;

import com.kaviarasu.bootstrapped_backend.Q40.dtos.LinkedInSearchRequest;
import com.kaviarasu.bootstrapped_backend.Q40.models.LinkedInSearchItem;

import java.util.List;

public interface ISearchService {
    List<LinkedInSearchItem> searchPeople(LinkedInSearchRequest linkedInSearchRequest);
}
