package com.example.springBootJPADemo.controller;

import com.example.springBootJPADemo.service.CustomerService;
import com.example.springBootJPADemo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    private List<Customer> getCustomers() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    private Customer getCustomer(@PathVariable int id) {
        Customer c = service.findOne(id);
        return c;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    private Customer postCustomers(@RequestBody Customer c) {
        return service.create(c);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Customer putCustomer(@PathVariable int id, @RequestBody Customer c) {
        c.setId(id);
        return service.update(c);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteCustomer(@PathVariable int id) {
        service.delete(id);
    }

}
