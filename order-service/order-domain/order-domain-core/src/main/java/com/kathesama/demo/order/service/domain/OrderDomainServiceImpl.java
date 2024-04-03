package com.kathesama.demo.order.service.domain;

import com.kathesama.demo.domain.vaueobject.DomainConstants;
import com.kathesama.demo.order.service.domain.entity.Order;
import com.kathesama.demo.order.service.domain.entity.Product;
import com.kathesama.demo.order.service.domain.entity.Restaurant;
import com.kathesama.demo.order.service.domain.events.OrderCancelledEvent;
import com.kathesama.demo.order.service.domain.events.OrderCreatedEvent;
import com.kathesama.demo.order.service.domain.events.OrderPaidEvent;
import com.kathesama.demo.order.service.domain.exceptions.OrderDomainException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static com.kathesama.demo.domain.vaueobject.DomainConstants.UTC;


@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService{
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        validateRestaurant(restaurant);
        setOrderProductInformation(order, restaurant);
        order.validateOrder();
        order.initializeOrder();
        log.info("Order with id: {} is initiated", order.getId().getValue());

        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id: {} is paid", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id: {} is approved", order.getId().getValue());
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id: {}", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with id: {} is cancelled", order.getId().getValue());
    }

    /***************************************************/
    private void validateRestaurant(Restaurant restaurant) {
        if (!restaurant.isActive()) {
            throw new OrderDomainException("Restaurant with id " + restaurant.getId().getValue() +
                    " is currently not active!");
        }
    }

    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        // aca se tiene una complejidad de n2 por los dos bucles, si se pasa a un hash map se reduce a uno
        order.getItems().forEach(orderItem ->
                restaurant.getProducts().forEach(
                        restaurantProduct -> {
                            Product currentProduct = orderItem.getProduct();
                                if (currentProduct.equals(restaurantProduct)) {
                                    currentProduct.updateWithConfirmedNameAndPrice(
                                            restaurantProduct.getName(),
                                            restaurantProduct.getPrice()
                                    );
                                }
                            }
                        )
                );
    }
}
