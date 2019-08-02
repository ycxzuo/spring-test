package com.yczuoxin.springboot.test15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/xss")
    public String xss(Model model) {

        // JS Code 需要被 Escape
        model.addAttribute("jsCode", "<script>alert('XSS attack')</script>");
        // HTML Code 不需要被 Escape（Unescape）
        model.addAttribute("htmlCode", "<span>Hello,World</span>");

        return "xss";
    }


}
