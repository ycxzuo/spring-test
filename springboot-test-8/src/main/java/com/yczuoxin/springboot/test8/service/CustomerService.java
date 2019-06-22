package com.yczuoxin.springboot.test8.service;

import com.yczuoxin.springboot.test8.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @PersistenceContext
    private EntityManager manager;

    public void add(Customer customer) {
        manager.persist(customer.getIdCard());
        manager.persist(customer.getStore());
        manager.persist(customer);
    }

    public Customer getById(Long id){
        return manager.find(Customer.class, id);
    }
}
