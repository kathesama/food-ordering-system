package com.kathesama.demo.order.service.domain.valueobject;

import com.kathesama.demo.domain.vaueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
