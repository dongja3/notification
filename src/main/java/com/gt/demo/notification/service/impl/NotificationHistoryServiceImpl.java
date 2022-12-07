package com.gt.demo.notification.service.impl;

import com.gt.demo.notification.model.NotificationHistory;
import com.gt.demo.notification.repo.NotificationHistoryRepo;
import com.gt.demo.notification.service.NotificationHistoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationHistoryServiceImpl  implements NotificationHistoryService {

    NotificationHistoryRepo notificationHistoryRepo;
    @Override
    @Transactional(readOnly = true)
    public List<NotificationHistory> findAll() {
        return notificationHistoryRepo.findAll();
    }

    @Override
    public void create(NotificationHistory notificationHistory) {
        notificationHistoryRepo.save(notificationHistory);
    }
}
