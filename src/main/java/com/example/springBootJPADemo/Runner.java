package com.example.springBootJPADemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Initial Runner start to run!");
        detect();
    }

    @Scheduled(fixedRate = 3000)
    public void detect() {
        LOGGER.info("will check new data");
    }
}
