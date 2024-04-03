package com.kathesama.demo.order.service.domain.valueobject;

import com.kathesama.demo.domain.vaueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}

