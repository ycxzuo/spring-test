package com.yczuoxin.springboot.test8.entity.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class CustomerListener {

    @PrePersist
    public void printBeforePersist(Object source){
        System.out.println("before persist");
    }

    @PostPersist
    public void printAfterPersist(Object source){
        System.out.println("after persist");
    }

}
