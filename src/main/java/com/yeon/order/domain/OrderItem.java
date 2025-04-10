package com.yeon.order.domain;

import com.yeon.common.domain.BaseEntity;
import com.yeon.product.domain.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * 주문서 상품 정보
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem extends BaseEntity {

    private String productCode;
    private long productQuantity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(Builder builder) {
        this.product = builder.product;
        this.productCode = builder.productCode;
        this.productQuantity = builder.productQuantity;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static class Builder {

        private final Product product;
        private final String productCode;
        private final long productQuantity;

        public Builder(Product product, long productQuantity) {
            this.product = product;
            this.productCode = product.getCode();
            this.productQuantity = productQuantity;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
