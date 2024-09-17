package com.orderService.service.impl;

import com.orderService.model.Order;
import com.orderService.producer.KafkaProducerService;
import com.orderService.repository.OrderRepository;
import com.orderService.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final KafkaProducerService kafkaProducerService;
    private final WebClient.Builder webClientBuilder;

    @Override
    public Mono<Order> createOrder(Order order) {
        return orderRepository.save(order)
                .flatMap(savedOrder ->
                        webClientBuilder.build()
                                .get()
                                .uri("http://localhost:8081/users/" + savedOrder.getUserId())
                                .retrieve()
                                .bodyToMono(SecurityProperties.User.class)
                                .map(user -> {
                                    return String.format(
                                            "Hola %s, tu pedido N° %d se realizó con éxito",
                                            user.getName(), savedOrder.getId());
                                })
                                .doOnNext(kafkaProducerService::sendNotification)
                                .then(Mono.just(savedOrder))
                );
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
