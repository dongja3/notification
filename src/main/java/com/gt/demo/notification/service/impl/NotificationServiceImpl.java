package com.gt.demo.notification.service.impl;

import com.gt.demo.notification.config.ActiveMQConfig;
import com.gt.demo.notification.dto.NotificationRequest;
import com.gt.demo.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import static  com.gt.demo.notification.config.ActiveMQConfig.NTF_QUEUE;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendNotificationMessage(NotificationRequest notificationRequest) {
        log.info("sending with convertAndSend() to queue <" + NTF_QUEUE + ">");
        jmsTemplate.convertAndSend(NTF_QUEUE, notificationRequest);
    }
}
