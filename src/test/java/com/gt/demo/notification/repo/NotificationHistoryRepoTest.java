package com.gt.demo.notification.repo;

import com.gt.demo.notification.model.NotificationHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class NotificationHistoryRepoTest {
    @Autowired
    NotificationHistoryRepo repo;

    @Test
    public void testSaveThenFindAll(){
        NotificationHistory notificationHistory = NotificationHistory.builder().status("Received").jsonMessage("hello").build();
        NotificationHistory ntfh = repo.save(notificationHistory);
        assertEquals("hello", ntfh.getJsonMessage());

        List<NotificationHistory> ntfhs = repo.findAll();
        assertEquals(1, ntfhs.size());
    }
}
