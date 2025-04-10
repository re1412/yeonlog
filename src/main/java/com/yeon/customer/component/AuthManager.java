package com.yeon.customer.component;

import jakarta.servlet.http.HttpServletRequest;

public class AuthManager {

    private final static String customerKey = "customerId";

    public static Long getCustomerId(HttpServletRequest request) {
        return (Long) request.getSession().getAttribute(customerKey);
    }

    public static void setCustomerId(HttpServletRequest request, Long customerId) {
        request.getSession().setAttribute(customerKey, customerId);
    }
}
