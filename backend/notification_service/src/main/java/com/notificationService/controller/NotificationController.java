package com.notificationService.controller;

import com.notificationService.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/status")
    public Mono<String> checkStatus() {
        return Mono.just("Servicio de notificaciones está activo");
    }

    @GetMapping
    public ResponseEntity<String> getLastNotification() {
        String lastMessage = notificationService.getLastMessage();
        return ResponseEntity.ok(lastMessage);
    }
}
