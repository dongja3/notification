package com.gt.demo.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest implements Serializable {
    private String appName;
    private String type;
    private String receiver;
    private String message;
}
