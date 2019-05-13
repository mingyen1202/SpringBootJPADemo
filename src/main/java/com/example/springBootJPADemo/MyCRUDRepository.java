package com.example.springBootJPADemo;

import com.example.springBootJPADemo.model.Beverage;
import org.springframework.data.repository.CrudRepository;

public interface MyCRUDRepository extends CrudRepository<Beverage, Long> {
}
