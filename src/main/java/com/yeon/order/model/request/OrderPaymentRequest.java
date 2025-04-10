package com.yeon.order.model.request;

import com.yeon.order.domain.Payment;
import com.yeon.common.type.CardType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
public class OrderPaymentRequest {

    @Schema(description = "전체 상품의 총 금액 (할인금 제외)")
    private long totalPrice;

    @Schema(description = "전체 상품의 총 할인금")
    private long discountPrice;
    @Schema(description = "결제타입 ? 신용카드 : 현금")
    private Payment.PayType payType;
    @Schema(description = "카드타입 ? 비자 : 마스터")
    @Nullable
    private CardType cardType;
    @Schema(description = "할부여부 ? 할부 : 일시불")
    private boolean installment;
    @Schema(description = "할부 개월 수")
    private int monthlyInstallment;

    @Builder
    public OrderPaymentRequest(long totalPrice, long discountPrice, Payment.PayType payType,
                               CardType cardType, boolean installment, int monthlyInstallment) {
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.payType = payType;
        this.cardType = cardType;
        this.installment = installment;
        this.monthlyInstallment = monthlyInstallment;
    }
}
