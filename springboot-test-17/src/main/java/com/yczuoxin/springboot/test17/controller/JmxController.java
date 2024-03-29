package com.yczuoxin.springboot.test17.controller;

import com.yczuoxin.springboot.test17.jmx.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmxController {

    @Autowired
    private SimpleBean simpleBean;

    @GetMapping("/jmx/simple-bean")
    public SimpleBean simpleBean(@RequestParam(required = false) Long id,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Integer age) {

        if (id != null) {
            simpleBean.setId(id);
        }
        if (name != null) {
            simpleBean.setName(name);
        }
        if (age != null) {
            simpleBean.setAge(age);
        }
        return simpleBean;
    }

}
