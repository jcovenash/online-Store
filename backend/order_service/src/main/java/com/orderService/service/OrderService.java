package com.orderService.service;

import com.orderService.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
    Mono<Order> createOrder(Order order);
    Flux<Order> getOrdersByUserId(Long userId);
    Mono<Order> getOrderById(Long id);
    Flux<Order> getAllOrders();
}
