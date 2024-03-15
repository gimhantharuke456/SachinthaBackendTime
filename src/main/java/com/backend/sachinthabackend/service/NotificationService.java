package com.backend.sachinthabackend.service;

import com.backend.sachinthabackend.model.Notification;

import com.backend.sachinthabackend.repositary.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> findAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> findNotificationById(String id) {
        return notificationRepository.findById(id);
    }

    public Optional<Notification> updateNotification(String id, Notification notificationDetails) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setRecipientId(notificationDetails.getRecipientId());
            notification.setType(notificationDetails.getType());
            notification.setMessage(notificationDetails.getMessage());
            notification.setDateTime(notificationDetails.getDateTime());
            return notificationRepository.save(notification);
        });
    }

    public boolean deleteNotification(String id) {
        return notificationRepository.findById(id).map(notification -> {
            notificationRepository.delete(notification);
            return true;
        }).orElse(false);
    }
}
