package com.yeon.product.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductRequest {

    @Schema(description = "상품 브랜드")
    private String brand;

    @Schema(description = "상품명")
    private String name;
    @Schema(description = "상품 요약정보")
    private String summary;
    @Schema(description = "상품 세부정보")
    private String content;
    @Schema(description = "상품 기본 금액")
    private int price;
    @Schema(description = "상품 총 재고")
    private int inventory;

    @Schema(description = "상품 이미지 정보")
    private String imgUrl;

    @Builder
    public ProductRequest(String brand, String name, String summary, String content,
                          int price, int inventory, String imgUrl) {
        this.brand = brand;
        this.name = name;
        this.summary = summary;
        this.content = content;
        this.price = price;
        this.inventory = inventory;
        this.imgUrl = imgUrl;
    }
}
