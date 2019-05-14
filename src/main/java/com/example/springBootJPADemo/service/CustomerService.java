package com.example.springBootJPADemo.service;

import com.example.springBootJPADemo.model.Customer;
import com.example.springBootJPADemo.repository.CustomerSimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerSimpleRepository repo;

    public List<Customer> findAll() {
        List<Customer> returnObj = new ArrayList<>();
        repo.findAll().forEach(returnObj::add);
        return returnObj;
    }

    public Customer findOne(int id) {
        return repo.findById(id).get();
    }

    public Customer create(Customer c) {
        return repo.save(c);
    }

    public Customer update(Customer c) {
        return  repo.save(c);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
