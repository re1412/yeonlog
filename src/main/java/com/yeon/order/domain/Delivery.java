package com.yeon.order.domain;

import com.yeon.common.domain.BaseEntity;
import com.yeon.order.model.request.OrderReceiverRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * 주문서 배송정보 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery extends BaseEntity {

    private String receiver;

    private String receiverPhoneNumber;

    private String receiverAddress;

    private String requestForDelivery; //배송 시 요청사항

    private Status deliveryStatus;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Delivery(Builder builder) {
        this.receiver = builder.receiver;
        this.receiverPhoneNumber = builder.receiverPhoneNumber;
        this.receiverAddress = builder.receiverAddress;
        this.requestForDelivery = builder.requestForDelivery;
        this.deliveryStatus = builder.deliveryStatus;
    }


    public void setOrder(Order order) {
        this.order = order;
    }

    @Getter
    public enum Status {

        PREPARE("배송 준비"),
        COMPLETE("배송 완료");

        private String name;

        Status(String name) {
            this.name = name;
        }
    }

    public static class Builder {
        private final String receiver;
        private final String receiverPhoneNumber;
        private final String receiverAddress;
        private final String requestForDelivery;
        private final Status deliveryStatus;

        public Builder(OrderReceiverRequest orderReceiver, Status deliveryStatus) {
            this.receiver = orderReceiver.getReceiver();
            this.receiverPhoneNumber = orderReceiver.getReceiverPhoneNumber();
            this.receiverAddress = orderReceiver.getReceiverAddress();
            this.requestForDelivery = orderReceiver.getRequestForDelivery();
            this.deliveryStatus = deliveryStatus;
        }

        public Delivery build() {
            return new Delivery(this);
        }
    }
}
