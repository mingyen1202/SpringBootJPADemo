package com.example.springBootJPADemo.repository;

import com.example.springBootJPADemo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c ORDER BY c.lastName, c.firstName")
    List<Customer> findAllOrderByName();

    @Query("SELECT c FROM Customer c ORDER BY c.firstName, c.lastName")
    List<Customer> findAllOrderByFirstName();

    Page<Customer> findAll(Pageable pageable);

    @Query("SELECT c FROM Customer c ORDER BY c.lastName, c.firstName")
    List<Customer> findAllOrderByName(Pageable pageable);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

    Integer countByFirstNameIgnoreCase(String firstName);

    List<Customer> findByAgeBetween(int low, int high);
}
