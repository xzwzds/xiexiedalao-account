package com.xzw.account.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 用户信息管理
 */
@RestController
@RequestMapping(value = "/admin")
public class UserInfoManageController {

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }



}
