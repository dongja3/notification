package com.gt.demo.notification.controller;

import com.gt.demo.notification.dto.NotificationRequest;
import com.gt.demo.notification.dto.NotificationResponse;
import com.gt.demo.notification.model.NotificationHistory;
import com.gt.demo.notification.service.NotificationHistoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notification")
@AllArgsConstructor
public class NotificationController {

    @Autowired
    private final QueueChannel queueChannel;
    @Autowired
    private final NotificationHistoryService notificationHistoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificationResponse createNotification(@RequestBody NotificationRequest notificationRequest){
        Message<String> message = buildNotificationMessage(notificationRequest);
        queueChannel.send(message);
        NotificationHistory notificationHistory =NotificationHistory.builder().jsonMessage(notificationRequest.getMessage())
                .status("Received").build();
        notificationHistoryService.create(notificationHistory);
        return new NotificationResponse();
    }

    private Message<String> buildNotificationMessage(NotificationRequest notificationRequest){
        return MessageBuilder.withPayload(notificationRequest.getMessage())
                .setHeader("receiver", notificationRequest.getReceiver())
                .setHeader("type", notificationRequest.getType()).build();
    }
}
