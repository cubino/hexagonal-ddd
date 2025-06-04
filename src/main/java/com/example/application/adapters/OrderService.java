package com.example.application.adapters;

import com.example.application.ports.OrderUseCase;
import com.example.domain.order.Order;
import com.example.domain.order.Money;
import com.example.domain.order.OrderDomainService;
import com.example.infrastructure.ports.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderUseCase {
    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;

    public OrderService(OrderDomainService orderDomainService, OrderRepository orderRepository) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(String customerId, Money amount) {
        Order order = orderDomainService.createOrder(customerId, amount);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void updateOrderStatus(String orderId, String status) {
        Order order = getOrder(orderId);
        orderDomainService.updateStatus(order, status);
        orderRepository.update(order);
    }
} 