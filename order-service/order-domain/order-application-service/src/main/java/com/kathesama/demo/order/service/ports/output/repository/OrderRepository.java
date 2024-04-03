package com.kathesama.demo.order.service.ports.output.repository;

import com.kathesama.demo.domain.vaueobject.OrderId;
import com.kathesama.demo.order.service.domain.entity.Order;
import com.kathesama.demo.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
