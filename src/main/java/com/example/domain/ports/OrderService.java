package com.example.domain.ports;

import com.example.domain.order.Order;
import com.example.domain.order.Money;

public interface OrderService {
    Order createOrder(String customerId, Money amount);
    Order getOrder(String orderId);
    void updateOrderStatus(String orderId, String status);
} 