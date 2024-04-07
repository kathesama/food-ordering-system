package com.kathesama.demo.order.service.domain;

import com.kathesama.demo.order.service.domain.entity.Order;
import com.kathesama.demo.order.service.domain.entity.Restaurant;
import com.kathesama.demo.order.service.domain.events.OrderCancelledEvent;
import com.kathesama.demo.order.service.domain.events.OrderCreatedEvent;
import com.kathesama.demo.order.service.domain.events.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
