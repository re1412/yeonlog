package com.yeon.order.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderItemRequest {

    @Schema(description = "상품 코드")
    private String productCode;
    @Schema(description = "상품 기본 금액")
    private long productPrice;

    @Schema(description = "상품 수량")
    private long productQuantity;

    @Builder
    public OrderItemRequest(String productCode, long productPrice, long productQuantity) {
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }
}
