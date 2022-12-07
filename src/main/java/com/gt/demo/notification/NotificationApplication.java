package com.gt.demo.notification;

import com.gt.demo.notification.service.NotificationQueueService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Queue;

@SpringBootApplication
@EnableScheduling
public class NotificationApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

}
