package com.yeon.customer.domain;

import com.yeon.common.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/**
 * 고객 주소 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address extends BaseEntity {

    private String address;
    private String zipCode;

    @JsonBackReference
    @ManyToOne
    Customer customer;

    @Builder
    public Address(String address, String zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
