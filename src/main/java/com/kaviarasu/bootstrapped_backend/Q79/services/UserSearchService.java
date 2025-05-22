package com.kaviarasu.bootstrapped_backend.Q79.services;


import com.kaviarasu.bootstrapped_backend.Q79.models.Sex;
import com.kaviarasu.bootstrapped_backend.Q79.models.User;
import com.kaviarasu.bootstrapped_backend.Q79.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchService {

    @Autowired
    private UserRepository userRepository;

    private final Integer pageSize = 5;

    public List<User> getUsersHavingAddress(String address, Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 0;
        }
        return userRepository.findByAddressContaining(
                address,
                PageRequest.of(pageNumber, pageSize)
        );
    }

    public List<User> getDetailsOfAllLadies(Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 0;
        }
        return userRepository.findBySex(
                Sex.FEMALE,
                PageRequest.of(pageNumber, pageSize)
        );
    }

    public List<User> getDetailsOfAllAdultMales(Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 0;
        }
        return userRepository.findBySexAndAgeGreaterThanEqual(
                Sex.MALE,
                18,
                PageRequest.of(pageNumber, pageSize)
        );
    }
}
