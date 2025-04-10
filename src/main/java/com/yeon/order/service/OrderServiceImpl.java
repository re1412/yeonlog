package com.yeon.order.service;

import com.yeon.common.exception.BaseException;
import com.yeon.customer.domain.Customer;
import com.yeon.customer.repository.CustomerRepository;
import com.yeon.order.domain.Delivery;
import com.yeon.order.domain.Order;
import com.yeon.order.domain.OrderItem;
import com.yeon.order.domain.Payment;
import com.yeon.order.model.request.OrderRequest;
import com.yeon.order.model.response.OrderDetailResponse;
import com.yeon.order.model.response.OrderResponse;
import com.yeon.order.repository.DeliveryRepository;
import com.yeon.order.repository.OrderItemRepository;
import com.yeon.order.repository.OrderRepository;
import com.yeon.order.repository.PaymentRepository;
import com.yeon.product.domain.Product;
import com.yeon.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PaymentRepository paymentRepository;
    private final DeliveryRepository deliveryRepository;
    private final PriceCalculator calculator;

    @Override
    @Transactional
    public OrderResponse registerOrder(Long customerId, OrderRequest orderRequest) {

        //실제 상품 데이터 금액 계산을 통한 요청 금액 검증 -> 현재 할인 금액은 포함되지 않음.
        long validateTotalPrice = calculator.calculateTotalPrice(orderRequest.getOrderItems());
        if (validateTotalPrice != orderRequest.getTotalByDiscount()) {
            throw new BaseException("주문한 상품의 금액과 실제 상품의 금액이 다릅니다.");
        }

        //고객정보 조회
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        //결제내역 등록
        Payment payment = new Payment.Builder(orderRequest.getOrderPayment()).description("상세 설명").build();
        paymentRepository.save(payment);

        //배송지 등록
        Delivery delivery = new Delivery.Builder(orderRequest.getOrderReceiver(), Delivery.Status.PREPARE).build();
        deliveryRepository.save(delivery);

        //고객 정보
        Order order = new Order.Builder(Order.OrderStatus.COMPLETE, customer, payment, delivery).build();

        //주문서 내 상품정보 추가
        orderRequest.getOrderItems().stream()
                .forEach(itemRequest -> {
                    Product product = productRepository.findProductByCode(itemRequest.getProductCode());
                    OrderItem orderItem = new OrderItem.Builder(product, itemRequest.getProductQuantity()).build();
                    order.addOrderItems(orderItem);
                });

        payment.setOrder(order);
        delivery.setOrder(order);

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getOrderItems());

        return OrderResponse.from(order);
    }

    @Override
    public OrderDetailResponse getOrderDetails(Long customerId, String orderCode) {
        Order order = orderRepository.findByCustomerIdAndCode(customerId, orderCode)
                .orElseThrow(() -> new BaseException("등록된 주문 정보가 없습니다."));

        return OrderDetailResponse.of(order, "결제가 완료되었습니다.");
    }
}
