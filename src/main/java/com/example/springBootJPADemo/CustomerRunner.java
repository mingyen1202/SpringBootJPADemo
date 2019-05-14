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
        Customer c = repo.save(new Customer(null, "Mark", "Ho"));
        LOGGER.info("create 1 customer {}", c.toString());
        repo.save(new Customer(null, "Peter", "Huang"));
        repo.save(new Customer(null, "John", "Lin"));
        repo.save(new Customer(null, "Paul", "Wu"));
        repo.save(new Customer(null, "Taddy", "Hi"));
        repo.save(new Customer(null, "Sam", "Liu"));
        repo.save(new Customer(null, "Sandy", "Chen"));
    }
}
