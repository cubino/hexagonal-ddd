package com.example.domain.ports;

import com.example.domain.order.Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String orderId);
    void update(Order order);
    List<Order> findByCustomerId(String customerId);
} 