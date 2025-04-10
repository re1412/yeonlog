package com.yeon.customer.controller;

import com.yeon.customer.component.AuthManager;
import com.yeon.customer.model.CustomerResponse;
import com.yeon.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "사용자 정보 조회 API 목록")
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "사용자 정보 조회", description = "파라미터를 넘기지 않아도 customerId=1 default 계정을 조회한다.")
    @GetMapping("/customer")
    public CustomerResponse findCustomer(HttpServletRequest request) {
        Long customerId = AuthManager.getCustomerId(request);

        return customerService.findCustomer(customerId);
    }
}
