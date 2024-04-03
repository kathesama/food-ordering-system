package com.kathesama.demo.order.service.ports.input.service;

import com.kathesama.demo.order.service.dto.create.CreateOrderCommand;
import com.kathesama.demo.order.service.dto.create.CreateOrderResponse;
import com.kathesama.demo.order.service.dto.track.TrackOrderQuery;
import com.kathesama.demo.order.service.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}