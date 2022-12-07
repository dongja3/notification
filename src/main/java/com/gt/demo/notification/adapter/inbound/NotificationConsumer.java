package com.gt.demo.notification.adapter.inbound;
import com.gt.demo.notification.dto.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import static com.gt.demo.notification.config.ActiveMQConfig.NTF_QUEUE;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {

    private final QueueChannel queueChannel;
    @JmsListener(destination = NTF_QUEUE)
    public void receiveMessage(@Payload NotificationRequest request,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
        log.info("received <" + request + ">");

        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("######          Message Details           #####");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("headers: " + headers);
        log.info("message: " + message.getPayload());
        log.info("session: " + session);
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");


        log.info(" Send message to Queue Channel");
        queueChannel.send(message);
        log.info(" Queue Size:" + queueChannel.getQueueSize());
    }
}
