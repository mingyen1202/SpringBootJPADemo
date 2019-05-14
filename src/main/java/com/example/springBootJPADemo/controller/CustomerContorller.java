package com.example.springBootJPADemo.controller;

import com.example.springBootJPADemo.model.Customer;
import com.example.springBootJPADemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "customers")
public class CustomerContorller {
    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    private String listAll(Model model) {
        List<Customer> customers = service.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

}
