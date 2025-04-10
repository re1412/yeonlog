package com.yeon.order.controller;

import com.yeon.common.controller.ApiController;
import com.yeon.customer.component.AuthManager;
import com.yeon.order.model.request.OrderRequest;
import com.yeon.order.model.response.OrderDetailResponse;
import com.yeon.order.model.response.OrderResponse;
import com.yeon.order.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "주문 API 목록")
public class OrderController extends ApiController {

    private final OrderService orderService;

    @Operation(summary = "주문서 등록(결제)", description = "주문서에 정보를 입력하고 결제하기 버튼을 누른다.")
    @PostMapping("/order")
    public OrderResponse registerOrder(HttpServletRequest request,
                                       @RequestBody OrderRequest orderRequest) {
        Long customerId = AuthManager.getCustomerId(request);
        return orderService.registerOrder(customerId, orderRequest);
    }

    @Operation(summary = "주문 결과 조회", description = "주문 성공 시 주문 정보를 조회한다.")
    @GetMapping("/order")
    public OrderDetailResponse getOrderDetails(HttpServletRequest request,
                                               @RequestParam("orderCode") String orderCode) {
        Long customerId = AuthManager.getCustomerId(request);
        return orderService.getOrderDetails(customerId, orderCode);
    }
}

