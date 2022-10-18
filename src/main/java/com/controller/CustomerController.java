package com.controller;

import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> listCustomer = customerService.findAll();
        modelAndView.addObject("customers", listCustomer);
        return modelAndView;
    }
    @GetMapping("/customerDetail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/customers")
    public ModelAndView updateDetail(@RequestParam Long id,String name,String email,String address){
        ModelAndView modelAndView = new ModelAndView("customers/list");
        Customer customer = new Customer(id,name,email,address);
        customerService.save(customer);
        List<Customer> listCustomer = customerService.findAll();
        modelAndView.addObject("customers",listCustomer);
        return modelAndView;
    }

}
