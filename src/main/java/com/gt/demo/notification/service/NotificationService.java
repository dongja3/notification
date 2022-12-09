package com.gt.demo.notification.service;

import com.gt.demo.notification.dto.NotificationRequest;
import org.springframework.messaging.Message;

public interface NotificationService {
    void sendNotificationMessage(NotificationRequest notificationRequest);

    void sendNotificationToQueue(Message message);
}
