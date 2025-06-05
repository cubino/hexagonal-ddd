package com.example.domain.order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String orderId);
    void update(Order order);
    List<Order> findByCustomerId(String customerId);
} 