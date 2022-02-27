package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/*
    @RestController:
        @Controller + @ResponseBody(可以加在 p1 or p2) = @RestController

    @ResponseBody的作用其实是将java对象转为json格式的数据。

    没有 @ResponseBody，如何返回页面???
        先在 pom 里面 添加 Thymeleaf 模板引擎
        在 templates 里面新建一个模板 index.html
        return 这个模板 // 这种模板现在用的比较少，大部分都是前后分离的架构
*/

// @RestController
@Controller
// @RequestMapping("/hello")
// p1
public class HelloController {

    @Value("${minMoney}")
    private BigDecimal minMoney;

    @Value("${description}")
    private String description;

    @Autowired
    private LimitConfig limitconfig;

    // http://localhost:8081/luckymoney/hello
    // http://localhost:8081/luckymoney/hi 都可以访问

    @GetMapping({"/hello", "/hi"})
    /* @PostMapping({"/hello", "/hi"})
       可以用postman 查看 post request

       @RequestMapping({"/hello", "/hi"}) 既可以处理 Get 又可以处理 Post。(不好)
    */

    // p2 @ResponseBody 放在这，是因为 say2() 要用模板引擎 thymeleaf 来返回页面
    @ResponseBody
    public String say(){
        return "Hello World" + "<br />\n" +
                "minMoney: " + minMoney + "<br />\n" +
                "说明：" + description + "<br />\n" +
                "LimitConfig Description: " + limitconfig.getDescription();
    }

    @GetMapping("/hello2") // http://localhost:8081/luckymoney/hello2
    public String say2(){
        return "index";
    }
}
