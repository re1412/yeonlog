package com.yeon.customer.model;

import com.yeon.customer.domain.Address;
import com.yeon.customer.domain.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomerResponse {

    private long id;
    @Schema(description = "사용자 아이디")
    private String customerId;
    @Schema(description = "사용자 이름")
    private String name;
    @Schema(description = "핸드폰 번호")
    private String mobile;
    @Schema(description = "이메일")
    private String email;
    @Schema(description = "활성화 여부")
    private boolean active;
    @Schema(description = "배송지 목록")
    private List<Address> addresses;

    @Schema(description = "사용자 프로필 이미지 경로")
    private String profileUrl;

    @Builder
    public CustomerResponse(Customer customer) {
        this.id = customer.getId();
        this.customerId = customer.getCustomerId();
        this.name = customer.getName();
        this.mobile = customer.getMobile();
        this.email = customer.getEmail();
        this.active = customer.isActive();
        this.addresses = customer.getAddresses();
        this.profileUrl = customer.getProfileUrl();
    }
}
