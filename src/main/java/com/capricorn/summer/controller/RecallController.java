package com.capricorn.summer.controller;

import com.capricorn.summer.service.IBecomingRichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class RecallController {

    @Autowired
    IBecomingRichService service;

    @RequestMapping("helloSummer")
    public String helloSummer(){
        return "index";
    }

    @RequestMapping("openFund")
    public String openFund(Model model){
        List<Map<String, Object>> allFundDetail = service.findAllFundDetail();
//        allFundDetail.forEach(detai->{
//            if (detai.get("FUND_VALUATION").toString().contains("-"))
//                detai.put("down","y");
//        });
        model.addAttribute("allFundDetail",allFundDetail);
        return "fund";
    }
}
