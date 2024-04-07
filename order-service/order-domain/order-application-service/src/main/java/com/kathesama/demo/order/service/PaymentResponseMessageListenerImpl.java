package com.kathesama.demo.order.service;

import com.kathesama.demo.order.service.dto.message.PaymentResponse;
import com.kathesama.demo.order.service.ports.input.message.listener.payment.PaymentRespMsgListnr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentResponseMessageListenerImpl implements PaymentRespMsgListnr {
    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {

    }

    @Override
    public void paymentCancelled(PaymentResponse paymentResponse) {

    }
}
