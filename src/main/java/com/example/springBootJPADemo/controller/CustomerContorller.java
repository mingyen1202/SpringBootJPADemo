package com.example.springBootJPADemo.controller;

import com.example.springBootJPADemo.CustomerForm;
import com.example.springBootJPADemo.model.Customer;
import com.example.springBootJPADemo.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @ModelAttribute
    private CustomerForm setupForm() {
        return new CustomerForm();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    private String create(@Valid CustomerForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return listAll(model);
        }
        Customer c = new Customer();
        BeanUtils.copyProperties(form, c);
        c.setAge(18);
        service.create(c);
        return "redirect:/customers";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    private String delete(@Valid CustomerForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return listAll(model);
        }
        Customer c = new Customer();
        BeanUtils.copyProperties(form, c);
        service.delete(c.getId());
        return "redirect:/customers";
    }

}
