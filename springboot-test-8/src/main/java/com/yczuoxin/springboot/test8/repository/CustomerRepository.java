package com.yczuoxin.springboot.test8.repository;

import com.yczuoxin.springboot.test8.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepository extends SimpleJpaRepository<Customer, Long> {

    @Autowired
    public CustomerRepository(EntityManager em) {
        super(Customer.class, em);
    }
}
