package com.example.springBootJPADemo.repository;

import com.example.springBootJPADemo.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerSimpleRepository extends CrudRepository<Customer, Integer> {

}
