package com.capricorn.summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RecallController {

    @RequestMapping("helloSummer")
    public String helloSummer(){
        return "index";
    }

    @RequestMapping("openFund")
    public String openFund(){
        return "fund";
    }
}
