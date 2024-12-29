package com.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Сервіс для оновлення даних у файлі кожні 10 секунд.
 */
@Service
public class FileUpdateService {

    private static final Logger logger = LoggerFactory.getLogger(FileUpdateService.class);
    private int counter = 0;

    @Scheduled(fixedRate = 10000) // Виконувати кожні 10 секунд
    public void updateFile() {
        counter += 5;
        String content = "Час: " + LocalDateTime.now() + ", Лічильник: " + counter + "\n";

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(content);
            logger.info("Дані оновлено у файлі: {}", content);
        } catch (IOException e) {
            logger.error("Помилка при оновленні файлу", e);
        }
    }
}
