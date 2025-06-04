package com.example.domain.order;

import lombok.Value;

import java.util.UUID;

@Value
public class Order {
    String id;
    String customerId;
    OrderStatus status;
    Money totalAmount;

    public Order(String customerId, Money totalAmount) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.status = OrderStatus.CREATED;
        this.totalAmount = totalAmount;
    }

    public Order(String id, String customerId, Money totalAmount, OrderStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public Order confirm() {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException("Order can only be confirmed when in CREATED status");
        }
        return new Order(id, customerId, totalAmount, OrderStatus.CONFIRMED);
    }

    public Order withStatus(OrderStatus newStatus) {
        return new Order(id, customerId, totalAmount, newStatus);
    }
} 