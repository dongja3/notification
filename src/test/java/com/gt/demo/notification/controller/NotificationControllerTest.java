package com.gt.demo.notification.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gt.demo.notification.dto.NotificationRequest;
import com.gt.demo.notification.model.NotificationHistory;
import com.gt.demo.notification.service.NotificationHistoryService;
import com.gt.demo.notification.service.NotificationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NotificationController.class)
public class NotificationControllerTest {
    @MockBean
    NotificationService notificationService;

    @MockBean
    NotificationHistoryService notificationHistoryService;
    @Autowired
    private MockMvc mvc;

    private String jsonString;


    @Test
    public void testCreateNotification() throws Exception {
        mvc.perform(post("/api/notification").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("received").value(true));
    }

    @Before
    public void setup() throws JsonProcessingException {
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .appName("TMS").receiver("13000000").type("SMS").message("hello").build();
        doNothing().when(notificationService).sendNotificationMessage(notificationRequest);

        NotificationHistory notificationHistory =NotificationHistory.builder().jsonMessage(notificationRequest.getMessage())
                .status("Received").build();
        doNothing().when(notificationHistoryService).create(notificationHistory);

        ObjectMapper Obj = new ObjectMapper();
        jsonString = Obj.writeValueAsString(notificationRequest);
    }
}
