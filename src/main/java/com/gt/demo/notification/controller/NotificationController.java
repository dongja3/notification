package com.gt.demo.notification.controller;

import com.gt.demo.notification.dto.NotificationRequest;
import com.gt.demo.notification.dto.NotificationResponse;
import com.gt.demo.notification.model.NotificationHistory;
import com.gt.demo.notification.service.NotificationHistoryService;
import com.gt.demo.notification.service.NotificationService;
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


    private final NotificationHistoryService notificationHistoryService;

    private final NotificationService notificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificationResponse createNotification(@RequestBody NotificationRequest notificationRequest){
        Message<String> message = buildNotificationMessage(notificationRequest);
        notificationService.sendNotificationToQueue(message);
        NotificationHistory notificationHistory =NotificationHistory.builder().jsonMessage(notificationRequest.getMessage())
                .status("Received").build();
        notificationHistoryService.create(notificationHistory);
        return new NotificationResponse();
    }

    @PostMapping("/sendmsg")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public NotificationResponse sendNotificationMessage(@RequestBody NotificationRequest notificationRequest){
        notificationService.sendNotificationMessage(notificationRequest);
        return new NotificationResponse();
    }

    private Message<String> buildNotificationMessage(NotificationRequest notificationRequest){
        return MessageBuilder.withPayload(notificationRequest.getMessage())
                .setHeader("receiver", notificationRequest.getReceiver())
                .setHeader("type", notificationRequest.getType()).build();
    }
}
