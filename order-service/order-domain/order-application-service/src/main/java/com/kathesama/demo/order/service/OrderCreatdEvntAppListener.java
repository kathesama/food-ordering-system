package com.kathesama.demo.order.service;

import com.kathesama.demo.order.service.domain.events.OrderCreatedEvent;
import com.kathesama.demo.order.service.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderCreatdEvntAppListener {
    private final OrderCreatedPaymentRequestMessage orderCreatedPaymentRequestMessage;

    public OrderCreatdEvntAppListener(OrderCreatedPaymentRequestMessage orderCreatedPaymentRequestMessage) {
        this.orderCreatedPaymentRequestMessage = orderCreatedPaymentRequestMessage;
    }

    @TransactionalEventListener
    void process(OrderCreatedEvent orderCreatedEvent){
        orderCreatedPaymentRequestMessage.publish(orderCreatedEvent);
    }
}
