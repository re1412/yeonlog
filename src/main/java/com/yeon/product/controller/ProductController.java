package com.yeon.product.controller;


import com.yeon.product.model.request.ProductRequest;
import com.yeon.product.model.response.ProductResponse;
import com.yeon.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "상품 API 목록")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "단일 상품 조회", description = "상품 ID로 단일 상품을 조회합니다.")
    @GetMapping("/product/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @Operation(summary = "전체 상품 조회", description = "page, size를 활용해 페이지 단위로 조회합니다.")
    @GetMapping("/products")
    public Page<ProductResponse> getProductList(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return productService.getProductList(pageable);
    }

    @Operation(summary = "상품 등록", description = "상품을 등록합니다.")
    @PostMapping("/product")
    public String registerProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.registerProduct(productRequest);
        return "SAVE PRODUCT COMPLETE";
    }

    @Operation(summary = "상품 정보 수정", description = "선택한 상품 정보를 수정합니다.")
    @PatchMapping("/product/{productId}")
    public void updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductRequest productRequest) {
        productService.updateProduct(productId, productRequest);
    }

    @Operation(summary = "단일 상품 삭제", description = "선택한 상품을 삭제합니다.")
    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}

