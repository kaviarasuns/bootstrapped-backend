package com.kaviarasu.bootstrapped_backend.Q51.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TA")
public class Ta extends ContractualEmployee {
    private Long numberOfHelpRequests;
}