package com.yczuoxin.springboot.test;

import com.yczuoxin.springboot.test.servlet.MyServletRequestListener;
import com.yczuoxin.springboot.test.spring.boot.MyFilter2;
import com.yczuoxin.springboot.test.spring.boot.MyServlet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

@SpringBootApplication
@ServletComponentScan("com.yczuoxin.springboot.test.servlet")
public class SpringbootTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest2Application.class, args);
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet2());
        servletRegistrationBean.setName("MyServlet2");
        servletRegistrationBean.addUrlMappings("/servlet2");
        servletRegistrationBean.addInitParameter("name", "mike2");

        return servletRegistrationBean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter2());
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistrationBean.addServletNames("MyServlet2");

        return filterRegistrationBean;
    }

    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyServletRequestListener());
        return servletListenerRegistrationBean;
    }
}
