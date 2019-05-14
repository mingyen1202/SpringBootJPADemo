package com.example.springBootJPADemo;

import com.example.springBootJPADemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerRunner4 implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner4.class);

    @Autowired
    CustomerRepository repo;

    @Override
    public void run(String... args) throws Exception {
        
    }
}
