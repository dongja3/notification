package com.gt.demo.notification.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationQueueService {
    private final QueueChannel queueChannel;

    @Scheduled(fixedDelay = 1000)
    public void distributeNotification(){
        Message message = queueChannel.receive();
        log.info("====message distributed：{}", message.getPayload());
    }
}
