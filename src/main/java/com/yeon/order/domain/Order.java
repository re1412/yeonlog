package com.yeon.order.domain;

import com.yeon.common.domain.BaseEntity;
import com.yeon.common.util.CodeGenerator;
import com.yeon.customer.domain.Customer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 주문 정보 Entity
 */
@Entity
@Getter
@Table(name = "orders") // Order-By 예약어로 인한 오류 방지
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String code; // 주문코드

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Builder builder) {
        this.code = builder.code;
        this.orderStatus = builder.orderStatus;
        this.customer = builder.customer;
        this.payment = builder.payment;
        this.delivery = builder.delivery;
    }

    public void addOrderItems(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static class Builder {
        private final String code;
        private final OrderStatus orderStatus;
        private final Customer customer;
        private final Payment payment;
        private final Delivery delivery;

        public Builder(OrderStatus orderStatus,
                       Customer customer, Payment payment, Delivery delivery) {
            this.code = CodeGenerator.generateWithPrefix("ORDER");
            this.orderStatus = orderStatus;
            this.customer = customer;
            this.payment = payment;
            this.delivery = delivery;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Getter
    public enum OrderStatus {
        WAIT("주문 대기"),
        COMPLETE("주문 완료"),
        CANCEL("주문 취소");

        private final String name;

        OrderStatus(String name) {
            this.name = name;
        }
    }
}
