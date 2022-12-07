package com.gt.demo.notification.service;

import com.gt.demo.notification.dto.NotificationRequest;

public interface NotificationService {
    void sendNotificationMessage(NotificationRequest notificationRequest);
}
