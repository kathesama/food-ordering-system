package com.kathesama.demo.order.service;

import com.kathesama.demo.order.service.domain.OrderDomainService;
import com.kathesama.demo.order.service.domain.OrderDomainServiceImpl;
import com.kathesama.demo.order.service.ports.output.message.publisher.payment.OrderCancelledPayReqMsgPub;
import com.kathesama.demo.order.service.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessage;
import com.kathesama.demo.order.service.ports.output.message.publisher.restaurantapproval.OrderPaidRestaurantReqMsgPub;
import com.kathesama.demo.order.service.ports.output.repository.CustomerRepository;
import com.kathesama.demo.order.service.ports.output.repository.OrderRepository;
import com.kathesama.demo.order.service.ports.output.repository.RestaurantRepository;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.kathesama.demo")
public class OrderTestConfiguration {
    @Bean
    public OrderCreatedPaymentRequestMessage orderCreatedPaymentRequestMessage() {
        return Mockito.mock(OrderCreatedPaymentRequestMessage.class);
    }

    @Bean
    public OrderCancelledPayReqMsgPub orderCancelledPayReqMsgPub(){
        return Mockito.mock(OrderCancelledPayReqMsgPub.class);
    }

    @Bean
    public OrderPaidRestaurantReqMsgPub orderPaidRestaurantReqMsgPub(){
        return Mockito.mock(OrderPaidRestaurantReqMsgPub.class);
    }

    @Bean
    public OrderRepository orderRepository() {
        return Mockito.mock(OrderRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public RestaurantRepository restaurantRepository() {
        return Mockito.mock(RestaurantRepository.class);
    }

    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
