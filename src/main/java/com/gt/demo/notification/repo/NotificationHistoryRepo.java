package com.gt.demo.notification.repo;

import com.gt.demo.notification.model.NotificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationHistoryRepo extends JpaRepository<NotificationHistory,String> {
}
