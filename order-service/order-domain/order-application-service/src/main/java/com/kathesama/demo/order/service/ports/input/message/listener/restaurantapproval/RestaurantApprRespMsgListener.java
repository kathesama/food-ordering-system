package com.kathesama.demo.order.service.ports.input.message.listener.restaurantapproval;

import com.kathesama.demo.order.service.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprRespMsgListener {

    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
