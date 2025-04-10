package com.yeon.order.service;

import com.yeon.common.exception.BaseException;
import com.yeon.order.model.request.OrderItemRequest;
import com.yeon.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceCalculator {

    private final ProductRepository productRepository;

    public long calculateTotalPrice(List<OrderItemRequest> orderItemRequests) {

        Long itemsPrice = 0L;

        for (OrderItemRequest orderItemRequest : orderItemRequests) {
            try {
                Long itemPrice = productRepository.getPriceByCode(orderItemRequest.getProductCode());
                itemsPrice += itemPrice * orderItemRequest.getProductQuantity();
            } catch (Exception e) {
                throw new BaseException("존재하지 않는 상품입니다.");
            }
        }

        return itemsPrice;
    }
}
