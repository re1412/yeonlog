package com.yeon.product.domain;


import com.yeon.common.domain.BaseEntity;
import com.yeon.common.util.CodeGenerator;
import com.yeon.product.model.request.ProductRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 상품 정보 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String code; // 상품 코드

    private String brand; //상품 브랜드

    private String name; //상품명

    private String summary; //상품요약

    private int inventory; //재고

    private long price; //기본 상품 금액

    @Lob
    private String content; //상품 상세 설명

    private String imgUrl;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductOption> productOption = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductExtension> productExtension = new ArrayList<>();

    public Product(String code, String brand, String name, String summary, int inventory,
                   String content, long price, String imgUrl) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.summary = summary;
        this.inventory = inventory;
        this.content = content;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductEditor.ProductEditorBuilder toEditor() {
        return ProductEditor.builder()
                .brand(brand)
                .name(name)
                .summary(summary)
                .inventory(inventory)
                .price(price)
                .content(content);
    }

    public void edit(ProductEditor productEditor) {
        name = productEditor.getName();
        brand = productEditor.getBrand();
        summary = productEditor.getSummary();
        inventory = productEditor.getInventory();
        content = productEditor.getContent();
        price = productEditor.getPrice();
    }

    public static Product of(ProductRequest request) {
        return new Product(CodeGenerator.generateWithPrefix("PRODUCT"), request.getBrand(), request.getName(), request.getSummary(),
                request.getInventory(), request.getContent() ,request.getPrice(), request.getImgUrl());
    }
}
