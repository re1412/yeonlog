package com.yeon.order.domain;

import com.yeon.common.domain.BaseEntity;
import com.yeon.common.type.CardType;
import com.yeon.order.model.request.OrderPaymentRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * 결제 내역 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private PayType payType; // 결제 타입

    @Enumerated(EnumType.STRING)
    private CardType cardType; // 카드 종류

    private long totalPrice; // 총 결제 금액
    private long discountPrice; //할인 금액

    private boolean installment; //할부 여부 true : 할부

    private int monthlyInstallment; //할부 개월수

    private String description;
    private LocalDateTime paymentDate;
    private LocalDateTime cancelDate;

    //환불 및 변경을 위해 주문과 양방향 일대일 관계 설정
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment(OrderPaymentRequest orderPayment) {
        this.payType = orderPayment.getPayType();
        this.totalPrice = orderPayment.getTotalPrice();
        this.discountPrice = orderPayment.getDiscountPrice();
        this.installment = orderPayment.isInstallment();
        this.monthlyInstallment = orderPayment.getMonthlyInstallment();
        this.paymentDate = LocalDateTime.now();
    }

    public Payment(Builder builder) {
        this.payType = builder.payType;
        this.cardType = builder.cardType;
        this.totalPrice = builder.totalPrice;
        this.discountPrice = builder.discountPrice;
        this.installment = builder.installment;
        this.monthlyInstallment = builder.monthlyInstallment;
        this.description = builder.description;
        this.paymentDate = builder.paymentDate;
    }

    public static class Builder {
        private final PayType payType; // 결제 타입
        private final CardType cardType; // 카드 종류

        private final long totalPrice; // 총 결제 금액
        private final long discountPrice; //할인 금액

        private final boolean installment; //할부 여부 true : 할부

        private final int monthlyInstallment; //할부 개월수

        private String description;
        private final LocalDateTime paymentDate;

        public Builder(OrderPaymentRequest request) {
            this.payType = request.getPayType();
            this.cardType = request.getCardType();
            this.totalPrice = request.getTotalPrice();
            this.discountPrice = request.getDiscountPrice();
            this.installment = request.isInstallment();
            this.monthlyInstallment = request.getMonthlyInstallment();
            this.paymentDate = LocalDateTime.now();
        }

        public Builder description(String value) {
            description = value;
            return this;
        }


        public Payment build() {
            return new Payment(this);
        }
    }
    @Getter
    public enum PayType {

        TRANSPORT(false, "무통장입금"),
        CREDITCARD(false, "신용카드"),

        TRANSPORT_CANCEL(true, "무통장입금 취소"),
        CREDITCARD_CANCEL(true, "신용카드 취소");

        private boolean cancelType;
        private String name;

        PayType(boolean isCancelType, String name) {
            cancelType = isCancelType;
            this.name = name;
        }
    }

}
