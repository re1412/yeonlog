package com.yeon.product.model.response;

import com.yeon.product.domain.Product;
import com.yeon.product.domain.ProductExtension;
import com.yeon.product.domain.ProductOption;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductResponse {

    private long id;
    @Schema(description = "상품 코드")
    private String code;
    @Schema(description = "상품 브랜드")
    private String brand;
    @Schema(description = "상품명")
    private String name;
    @Schema(description = "상품 요약")
    private String summary;
    @Schema(description = "상품 재고")
    private int inventory;
    @Schema(description = "상품 기본 금액")
    private long price;
    @Schema(description = "상품 정보")
    private String content;
    @Schema(description = "상품 이미지")
    private String imgUrl;
    @Schema(description = "상품 옵션 리스트")
    private List<ProductOption> productOption;
    @Schema(description = "상품 추가 구매 리스트")
    private List<ProductExtension> productExtension;

    public ProductResponse(long id, String code, String brand, String name, String summary, int inventory,
                           long price, String content, String imgUrl, List<ProductOption> productOption,
                           List<ProductExtension> productExtension) {
        this.id = id;
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.summary = summary;
        this.inventory = inventory;
        this.price = price;
        this.content = content;
        this.imgUrl = imgUrl;
        this.productOption = productOption;
        this.productExtension = productExtension;
    }

    public ProductResponse(Product product) {
        this.brand = product.getBrand();
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.summary = product.getSummary();
        this.inventory = product.getInventory();
        this.price = product.getPrice();
        this.content = product.getContent();
        this.imgUrl = product.getImgUrl();
        this.productOption = product.getProductOption();
        this.productExtension = product.getProductExtension();
    }

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getCode(), product.getBrand(),
                product.getName(), product.getSummary(), product.getInventory(), product.getPrice(),
                product.getContent(), product.getImgUrl(), product.getProductOption(), product.getProductExtension());
    }
}
