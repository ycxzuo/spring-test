package com.yczuoxin.springboot.test8.controller;

import com.yczuoxin.springboot.test8.entity.Customer;
import com.yczuoxin.springboot.test8.repository.CustomerRepository;
import com.yczuoxin.springboot.test8.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/findAll")
    public List<Customer> findAll(){
        return repository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer){
        service.add(customer);
        Long id = customer.getId();
        return service.getById(id);
    }

}
