package com.gt.demo.notification.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;

@Configuration
@Slf4j
public class MessageChannelConfig {

    @Bean
    public QueueChannel messageChannel(){
        log.info("message channel initialized.");
        return new QueueChannel();
    };

}
