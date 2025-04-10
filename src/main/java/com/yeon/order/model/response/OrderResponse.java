package com.yeon.order.model.response;

import com.yeon.order.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResponse {

    private long id;

    @Schema(description = "주문번호")
    private String code;

    public OrderResponse(long id, String code) {
        this.id = id;
        this.code = code;
    }

    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(), order.getCode());
    }
}
