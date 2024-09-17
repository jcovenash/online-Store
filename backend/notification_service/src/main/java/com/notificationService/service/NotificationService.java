package com.notificationService.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String message) {
        // Aquí puedes implementar lógica para enviar la notificación, por ejemplo:
        System.out.println("Enviando notificación: " + message);
        // Podrías también integrar con un sistema de notificaciones real.
    }
}
