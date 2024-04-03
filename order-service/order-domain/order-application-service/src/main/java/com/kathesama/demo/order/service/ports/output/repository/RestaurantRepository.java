package com.kathesama.demo.order.service.ports.output.repository;

import com.kathesama.demo.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
