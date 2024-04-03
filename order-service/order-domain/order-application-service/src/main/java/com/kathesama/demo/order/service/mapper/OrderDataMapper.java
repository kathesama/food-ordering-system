package com.kathesama.demo.order.service.mapper;

import com.kathesama.demo.domain.vaueobject.CustomerId;
import com.kathesama.demo.domain.vaueobject.Money;
import com.kathesama.demo.domain.vaueobject.ProductId;
import com.kathesama.demo.domain.vaueobject.RestaurantId;
import com.kathesama.demo.order.service.domain.entity.Order;
import com.kathesama.demo.order.service.domain.entity.OrderItem;
import com.kathesama.demo.order.service.domain.entity.Product;
import com.kathesama.demo.order.service.domain.entity.Restaurant;
import com.kathesama.demo.order.service.domain.valueobject.StreetAddress;
import com.kathesama.demo.order.service.dto.create.CreateOrderCommand;
import com.kathesama.demo.order.service.dto.create.CreateOrderResponse;
import com.kathesama.demo.order.service.dto.create.OrderAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {
    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand){
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                        new Product(
                                new ProductId(orderItem.getProductId())
                        )
                ).collect(Collectors.toList()))
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(
            List<com.kathesama.demo.order.service.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }
}
