package com.yczuoxin.springboot.test16.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jTest.class.getName());
        logger.info("Hello World".replace(" ", ""));
    }
}
