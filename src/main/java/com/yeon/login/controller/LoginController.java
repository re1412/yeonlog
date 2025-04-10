package com.yeon.login.controller;

import com.yeon.customer.component.AuthManager;
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
@Tag(name = "사용자 로그인 / 로그아웃")
public class LoginController {

    @Operation(summary = "로그인", description = "")
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        AuthManager.setCustomerId(request,1L);
        return request.getSession().getId();
    }

    @Operation(summary = "로그아웃", description = "")
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "logout successful";
    }

}
