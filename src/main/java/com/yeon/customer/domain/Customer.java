package com.yeon.customer.domain;

import com.yeon.common.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 정보 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String customerId;
    private String name;
    private String mobile;

    private String email;
    private boolean active;

    private String profileUrl;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @Builder
    public Customer(String customerId, String name, String mobile, String email,
                    boolean active, String profileUrl) {
        this.customerId = customerId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.active = active;
        this.profileUrl = profileUrl;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setCustomer(this);
    }
}
