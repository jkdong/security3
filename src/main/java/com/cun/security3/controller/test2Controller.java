package com.cun.security3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protal")
public class test2Controller {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/inner")
    public String inner(){
        return "inner";
    }
}
