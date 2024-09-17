package com.userService.service;

import com.userService.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> createUser(User user);
    Flux<User> getAllUsers();
    Mono<User> getUserById(Long id);
    Mono<Void> deleteUser(Long id);
}
