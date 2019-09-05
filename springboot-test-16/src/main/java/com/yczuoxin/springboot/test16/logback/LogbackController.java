package com.yczuoxin.springboot.test16.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {

    private Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @GetMapping("/get/{message}")
    public String getMessage(@PathVariable String message){
        String log = "message : " + message;
        logger.info(log);
        return log;
    }
}
