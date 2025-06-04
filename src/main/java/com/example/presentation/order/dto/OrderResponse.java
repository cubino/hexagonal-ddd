package com.example.presentation.order.dto;

import com.example.domain.order.Order;
import com.example.domain.order.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {
    private String id;
    private String customerId;
    private OrderStatus status;
    private BigDecimal amount;
    private String currency;

    public static OrderResponse fromDomain(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setCustomerId(order.getCustomerId());
        response.setStatus(order.getStatus());
        response.setAmount(order.getTotalAmount().getAmount());
        response.setCurrency(order.getTotalAmount().getCurrency());
        return response;
    }
} 