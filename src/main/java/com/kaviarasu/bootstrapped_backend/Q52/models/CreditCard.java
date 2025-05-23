package com.kaviarasu.bootstrapped_backend.Q52.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD")
@AttributeOverride(name = "owner", column = @Column(name = "CREDIT_CARD_OWNER"))
public class CreditCard extends PurchaseDetails {
    protected String cardNumber;
    protected Long creditLimit;
}

