package com.xzw.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xieziwei
 * @version 2021/8/22
 * @description 登录处理
 */
@RequestMapping
@Controller // SpringMVC的处理必须添加到组件
public class LoginController {

    @PostMapping("/to_error")
    public String error(){
        return "/common/error";
    }

    @PostMapping ("/success")
    public String success(){
        return "/common/success";
    }

    @PostMapping("/session/invalid")
    public String invaild(){
        return "/common/invalid";
    }
}
