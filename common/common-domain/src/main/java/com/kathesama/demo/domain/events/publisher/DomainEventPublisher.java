package com.kathesama.demo.domain.events.publisher;

import com.kathesama.demo.domain.events.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
