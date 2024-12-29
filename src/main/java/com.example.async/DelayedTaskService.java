package com.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Сервіс для відкладеного завдання, що виконується через 5 секунд після запуску.
 */
@Service
public class DelayedTaskService {

    private static final Logger logger = LoggerFactory.getLogger(DelayedTaskService.class);
    private final ScheduledExecutorService executorService;

    public DelayedTaskService(ScheduledExecutorService executorService) {
        this.executorService = executorService;
    }

    @PostConstruct
    public void scheduleDelayedTask() {
        executorService.schedule(() -> {
            logger.info("5 секунд від запуску програми");
        }, 5, TimeUnit.SECONDS);
    }
}
