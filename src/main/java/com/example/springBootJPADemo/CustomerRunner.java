package com.example.springBootJPADemo;

import com.example.springBootJPADemo.model.Customer;
import com.example.springBootJPADemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class CustomerRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner.class);

    @Autowired
    CustomerRepository repo;

    @Override
    public void run(String... args) throws Exception {
        initSampleData();
        repo.findAll().forEach(c -> LOGGER.info(c.toString()));
        repo.findAllOrderByName().forEach(c -> LOGGER.info(c.toString()));
        repo.findAllOrderByFirstName().forEach(c -> LOGGER.info(c.toString()));
    }

    private void initSampleData() {
        Customer c = repo.save(new Customer(null, "Mark", "Ho", 55));
        LOGGER.info("create 1 customer {}", c.toString());
        repo.save(new Customer(null, "Peter", "Huang", 40));
        repo.save(new Customer(null, "John", "Lin", 20));
        repo.save(new Customer(null, "Paul", "Wu", 22));
        repo.save(new Customer(null, "Taddy", "Hi", 70));
        repo.save(new Customer(null, "Sam", "Liu", 15));
        repo.save(new Customer(null, "Sandy", "Chen", 35));
        repo.save(new Customer(null, "Mark", "Chen", 5));
    }
}
