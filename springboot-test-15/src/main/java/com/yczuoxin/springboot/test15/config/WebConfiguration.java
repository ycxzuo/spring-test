package com.yczuoxin.springboot.test15.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {


        registry.addViewController("/iframe-parent").setViewName("iframe-parent");
        registry.addViewController("/iframe-child.html").setViewName("iframe-child");
        registry.addViewController("/login.html").setViewName("login");

    }

}