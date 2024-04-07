package com.kathesama.demo.order.service;

import com.kathesama.demo.order.service.dto.message.RestaurantApprovalResponse;
import com.kathesama.demo.order.service.ports.input.message.listener.restaurantapproval.RestaurantApprRespMsgListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprRespMsgListener {
    @Override
    public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {

    }

    @Override
    public void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse) {

    }
}
