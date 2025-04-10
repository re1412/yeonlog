package com.yeon.product.domain;


import com.yeon.common.domain.BaseEntity;
import com.yeon.product.model.request.ProductRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * 상품의 추가 상품 정보 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductExtension extends BaseEntity {


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String name; //상품명

    private long price; //기본 상품 금액

    public ProductExtension(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public ProductEditor.ProductEditorBuilder toEditor() {
        return ProductEditor.builder()
                .name(name)
                .price(price);
    }

    public void edit(ProductEditor productEditor) {
        name = productEditor.getName();
        price = productEditor.getPrice();
    }

    public static ProductExtension of(ProductRequest request) {
        return new ProductExtension(request.getName(), request.getPrice());
    }
}
