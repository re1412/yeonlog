package com.yeon.order.service;

import com.yeon.order.model.request.OrderRequest;
import com.yeon.order.model.response.OrderDetailResponse;
import com.yeon.order.model.response.OrderResponse;

public interface OrderService {
    OrderResponse registerOrder(Long customerId, OrderRequest orderRequest);

    OrderDetailResponse getOrderDetails(Long customerId, String orderCode);
}
