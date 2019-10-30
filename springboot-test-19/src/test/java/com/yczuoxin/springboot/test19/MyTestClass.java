package com.yczuoxin.springboot.test19;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(JunitTestExtension.class)
class MyTestClass {

    @Test
    void myTestMethod1(){
        System.out.println("test1");
    }

    @Test
    void myTestMethod2(){
        System.out.println("test2");
    }

}
