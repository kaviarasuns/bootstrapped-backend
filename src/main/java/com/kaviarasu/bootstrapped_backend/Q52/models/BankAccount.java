package com.kaviarasu.bootstrapped_backend.Q52.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
@AttributeOverride(name = "owner", column = @Column(name = "ACCOUNT_HOLDER"))
public class BankAccount extends PurchaseDetails {
    protected String bankName;
    protected String number;
}