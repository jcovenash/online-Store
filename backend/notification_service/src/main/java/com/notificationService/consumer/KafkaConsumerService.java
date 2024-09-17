package com.notificationService.consumer;

import com.notificationService.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final NotificationService notificationService;

    public KafkaConsumerService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "notification-topic", groupId = "notification-service")
    public void listen(String message) {
        System.out.println("Mensaje recibido: " + message);
        notificationService.sendNotification(message);
    }
}
