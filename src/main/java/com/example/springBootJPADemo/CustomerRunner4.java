package com.example.springBootJPADemo;

import com.example.springBootJPADemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 4)
public class CustomerRunner4 implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner4.class);

    @Autowired
    CustomerRepository repo;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("get some customer query");
        repo.findByFirstName("Mark").forEach(c -> LOGGER.info(c.toString()));
        repo.findByFirstNameAndLastName("Mark", "Ho").forEach(c -> LOGGER.info(c.toString()));
        repo.findByFirstNameOrLastName("Mark", "Chen").forEach(c -> LOGGER.info(c.toString()));
        LOGGER.info("first name is mark, count={}", repo.countByFirstNameIgnoreCase("mark"));
        repo.findByAgeBetween(0, 40).forEach(c -> LOGGER.info(c.toString()));
    }
}
