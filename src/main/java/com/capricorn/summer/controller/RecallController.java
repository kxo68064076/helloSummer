package com.capricorn.summer.controller;

import com.capricorn.summer.service.IBecomingRichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.HashMap;
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
        Map<String, Object> param = new HashMap<>();
        param.put("totalValue",null);
        param.put("outFlag",null);
        service.fundQueryValue(param);
        if (param.get("outFlag").toString().equals("0")){
            String totalValue = String.format("%.2f", (new BigDecimal(param.get("totalValue").toString())));
            param.put("totalValue",totalValue);
        }

//        allFundDetail.forEach(detai->{
//            if (detai.get("FUND_VALUATION").toString().contains("-"))
//                detai.put("down","y");
//        });
        model.addAttribute("allFundDetail",allFundDetail);
        model.addAttribute("fundQueryValue",param);
        return "fund";
    }
}
