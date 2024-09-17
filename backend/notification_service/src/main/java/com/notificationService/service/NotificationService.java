package com.notificationService.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String message) {
        System.out.println("Enviando notificación: " + message);
    }
}
