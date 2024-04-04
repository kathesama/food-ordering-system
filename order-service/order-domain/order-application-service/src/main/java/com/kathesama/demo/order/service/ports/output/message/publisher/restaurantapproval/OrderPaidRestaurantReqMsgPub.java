package com.kathesama.demo.order.service.ports.output.message.publisher.restaurantapproval;

import com.kathesama.demo.domain.events.publisher.DomainEventPublisher;
import com.kathesama.demo.order.service.domain.events.OrderPaidEvent;

public interface OrderPaidRestaurantReqMsgPub extends DomainEventPublisher<OrderPaidEvent> {
}
