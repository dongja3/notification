package com.gt.demo.notification.service;

import com.gt.demo.notification.model.NotificationHistory;

import java.util.List;

public interface NotificationHistoryService {
    List<NotificationHistory> findAll();

    void create(NotificationHistory notificationHistory);
}
