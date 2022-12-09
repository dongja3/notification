package com.gt.demo.notification.service;

import com.gt.demo.notification.model.NotificationHistory;
import com.gt.demo.notification.repo.NotificationHistoryRepo;
import com.gt.demo.notification.service.impl.NotificationHistoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class NotificationHistoryServiceTest {
    @TestConfiguration
    static class NotificationHistoryServiceTestContextConfiguration {
        @Bean
        public NotificationHistoryService notificationHistoryService() {
            return new NotificationHistoryServiceImpl();
        }
    }

    @Autowired
    NotificationHistoryService notificationHistoryService;

    @MockBean
    NotificationHistoryRepo notificationHistoryRepo;

    @Test
    public void whenHistoryInRepo_thenCanSearchOut(){
        assertEquals(2, notificationHistoryService.findAll().size());
    }

    @Before
    public void setup(){
        NotificationHistory n1=  NotificationHistory.builder().id("1").status("Received").jsonMessage("notification-1").build();
        NotificationHistory n2=  NotificationHistory.builder().id("2").status("Received").jsonMessage("notification-2").build();
        List<NotificationHistory> nhs = Arrays.asList(n1,n2);
        Mockito.when(notificationHistoryRepo.findAll()).thenReturn(nhs);
    }


}
