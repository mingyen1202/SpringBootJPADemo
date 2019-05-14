package com.example.springBootJPADemo;

import com.example.springBootJPADemo.model.Beverage;
import com.example.springBootJPADemo.repository.MyCRUDRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    @Autowired
    MyCRUDRepository myRepo;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Initial Runner start to run!");
        myRepo.deleteAll();
        LOGGER.info("clear finish, will try to add something");
        addSampleData();
    }

    private void addSampleData() {
        myRepo.save(new Beverage("Americano", "black coffee"));
        myRepo.save(new Beverage("Earl Gray Team", "Hot breakfast tea"));
        myRepo.save(new Beverage("Latte", "coffee with triple hot milk"));
        myRepo.save(new Beverage("Green Tea", "macha with milk and sugar"));
    }

//    @Scheduled(fixedRate = 3000)
    public void detect() {
        LOGGER.info("will check new data");
    }
}
