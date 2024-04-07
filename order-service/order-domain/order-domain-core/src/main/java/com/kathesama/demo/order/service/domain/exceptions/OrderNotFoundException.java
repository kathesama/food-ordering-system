package com.kathesama.demo.order.service.domain.exceptions;

import com.kathesama.demo.domain.exception.DomainException;

public class OrderNotFoundException extends DomainException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
