package com.example.springBootJPADemo.runner;

import com.example.springBootJPADemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Order(value = 3)
public class CustomerRunner3 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner3.class);

    @Autowired
    CustomerRepository repo;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("page with sort!");
        Pageable pageable = PageRequest.of(0, 4);
        repo.findAllOrderByName(pageable).forEach(c -> LOGGER.info(c.toString()));
        Pageable nextPageable = pageable.next();
        repo.findAllOrderByName(nextPageable).forEach(c -> LOGGER.info(c.toString()));

    }
}
