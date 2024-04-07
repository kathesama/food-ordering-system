package com.kathesama.demo.order.service;

import com.kathesama.demo.order.service.domain.events.OrderCreatedEvent;
import com.kathesama.demo.order.service.dto.create.CreateOrderCommand;
import com.kathesama.demo.order.service.dto.create.CreateOrderResponse;
import com.kathesama.demo.order.service.mapper.OrderDataMapper;
import com.kathesama.demo.order.service.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {
    private final OrderCreateHelper orderCreateHelper;
    private final OrderDataMapper orderDataMapper;
    private final OrderCreatedPaymentRequestMessage orderCreatedPaymentRequestMessage;

    public OrderCreateCommandHandler(
            OrderCreateHelper orderCreateHelper,
            OrderDataMapper orderDataMapper,
            OrderCreatedPaymentRequestMessage orderCreatedPaymentRequestMessage
    ) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
        this.orderCreatedPaymentRequestMessage = orderCreatedPaymentRequestMessage;
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);

        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        orderCreatedPaymentRequestMessage.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder(),
                "Order created successfully");
    }
}
