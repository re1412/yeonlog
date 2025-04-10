package com.yeon.order.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderReceiverRequest {
    /**
     * 배송정보 -> 변경이 되던 안되던 주문서에만 저장
     */
    @Schema(description = "받는 사람")
    private String receiver;
    @Schema(description = "받는 사람 휴대폰번호")
    private String receiverPhoneNumber;
    @Schema(description = "받는 사람 주소 ")
    private String receiverAddress;
    @Schema(description = "배송 요청사항")
    private String requestForDelivery;

    @Builder
    public OrderReceiverRequest(String receiver, String receiverPhoneNumber, String receiverAddress, String requestForDelivery) {
        this.receiver = receiver;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receiverAddress = receiverAddress;
        this.requestForDelivery = requestForDelivery;
    }
}
