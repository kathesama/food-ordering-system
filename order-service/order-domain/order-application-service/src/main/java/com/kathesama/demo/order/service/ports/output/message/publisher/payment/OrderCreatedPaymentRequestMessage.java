package com.kathesama.demo.order.service.ports.output.message.publisher.payment;

import com.kathesama.demo.domain.events.publisher.DomainEventPublisher;
import com.kathesama.demo.order.service.domain.events.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessage extends DomainEventPublisher<OrderCreatedEvent> {
}
