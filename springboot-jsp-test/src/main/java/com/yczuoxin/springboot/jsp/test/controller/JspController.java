package com.yczuoxin.springboot.jsp.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JspController {

    @RequestMapping("index")
    public String index(Model model, @RequestParam("message") String message) {
        model.addAttribute("message", message);
        return "index";
    }

}
