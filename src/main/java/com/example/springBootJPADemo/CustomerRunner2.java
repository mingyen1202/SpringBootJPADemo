package com.example.springBootJPADemo;

import com.example.springBootJPADemo.model.Customer;
import com.example.springBootJPADemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class CustomerRunner2 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner2.class);

    @Autowired
    private CustomerRepository repo;

    @Override
    public void run(String... args) throws Exception {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Customer> currentPage = repo.findAll(pageable);
        LOGGER.info("total page = {}", currentPage.getTotalPages());
        LOGGER.info("total emelment = {}", currentPage.getTotalElements());

        LOGGER.info("%%%% get page 0 %%%");
        currentPage.get().forEach(c -> LOGGER.info(c.toString()));
        Pageable nextPageable = pageable.next();
        Page<Customer> nextPage = repo.findAll(nextPageable);
        LOGGER.info("%%%% get next page 1 %%%");
        nextPage.get().forEach(c -> LOGGER.info(c.toString()));
    }
}
