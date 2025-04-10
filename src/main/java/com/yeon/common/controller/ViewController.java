package com.yeon.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 화면 View Controller
 */
@Controller
public class ViewController {

    /**
     * 제품목록 화면
     * @return
     */
    @GetMapping("/products")
    public String productList() {
        return "product/product_list";
    }

    /**
     * 제품상세 화면
     * @return
     */
    @GetMapping("/product/{productId}")
    public String productDetail(@PathVariable String productId) {
        // productId 미사용
        return "product/product_detail";
    }

    /**
     * 주문결제 화면
     * @return
     */
    @GetMapping("/order/payment")
    public String orderPayment() {
        return "order/order_payment";
    }

    /**
     * 주문완료 화면
     * @return
     */
    @GetMapping("/order/result")
    public String orderResult() {
        return "order/order_result";
    }

}
