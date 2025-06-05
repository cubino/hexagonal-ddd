package com.example.application.order;

import com.example.domain.order.Order;
import com.example.domain.ports.OrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmOrderUseCase {
    private final OrderRepository orderRepository;

    public Order execute(String orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
        
        Order confirmedOrder = order.confirm();
        return orderRepository.save(confirmedOrder);
    }
} 