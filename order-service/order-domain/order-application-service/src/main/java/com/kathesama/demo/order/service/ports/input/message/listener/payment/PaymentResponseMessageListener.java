package com.kathesama.demo.order.service.ports.input.message.listener.payment;

import com.kathesama.demo.order.service.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}

