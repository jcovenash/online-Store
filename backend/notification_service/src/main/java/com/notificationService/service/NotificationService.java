package com.notificationService.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private String lastMessage = "No hay notificaciones";

    public void sendNotification(String message) {
        System.out.println("Enviando notificación: " + message);
        lastMessage = message;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
