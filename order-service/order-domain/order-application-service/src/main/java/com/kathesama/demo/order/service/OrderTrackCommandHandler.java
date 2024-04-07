package com.kathesama.demo.order.service;

import com.kathesama.demo.order.service.domain.entity.Order;
import com.kathesama.demo.order.service.domain.exceptions.OrderNotFoundException;
import com.kathesama.demo.order.service.domain.valueobject.TrackingId;
import com.kathesama.demo.order.service.dto.track.TrackOrderQuery;
import com.kathesama.demo.order.service.dto.track.TrackOrderResponse;
import com.kathesama.demo.order.service.mapper.OrderDataMapper;
import com.kathesama.demo.order.service.ports.output.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {
    private final OrderDataMapper orderDataMapper;

    private final OrderRepository orderRepository;

    public OrderTrackCommandHandler(OrderDataMapper orderDataMapper, OrderRepository orderRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        Optional<Order> orderResult = orderRepository.findByTrackingId(
                new TrackingId(trackOrderQuery.getOrderTrackingId()));

        if (orderResult.isEmpty()) {
            log.warn("Could not find order with tracking id: {}", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException("Could not find order with tracking id: " +
                    trackOrderQuery.getOrderTrackingId());
        }

        return null;
    }
}
