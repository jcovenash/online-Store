package com.orderService.service.impl;

import com.orderService.model.Order;
import com.orderService.repository.OrderRepository;
import com.orderService.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Mono<Order> createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Flux<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Mono<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
