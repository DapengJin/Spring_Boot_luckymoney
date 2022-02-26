package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class HelloController {

    @Value("${minMoney}")
    private BigDecimal minMoney;

    @Value("${description}")
    private String description;

    @Autowired
    private LimitConfig limitconfig;

    @GetMapping("/hello")
    public String say(){
        return "Hello World" + "<br />\n" +
                "minMoney: " + minMoney + "<br />\n" +
                "说明：" + description + "<br />\n" +
                "LimitConfig Description: " + limitconfig.getDescription();
    }
}
