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
        // Aquí puedes implementar la lógica para manejar las notificaciones.
        System.out.println("Mensaje recibido: " + message);
        // Implementar la lógica para enviar la notificación a través del puerto o de la manera que necesites.
        notificationService.sendNotification(message);
    }
}
