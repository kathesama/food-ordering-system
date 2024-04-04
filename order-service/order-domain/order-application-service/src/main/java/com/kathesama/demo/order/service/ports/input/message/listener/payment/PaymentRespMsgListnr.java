package com.kathesama.demo.order.service.ports.input.message.listener.payment;

import com.kathesama.demo.order.service.dto.message.PaymentResponse;

public interface PaymentRespMsgListnr {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}

