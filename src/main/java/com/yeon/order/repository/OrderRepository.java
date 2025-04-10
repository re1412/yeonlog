package com.yeon.order.repository;

import com.yeon.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByCustomerIdAndCode(Long customerId, String code);
}
