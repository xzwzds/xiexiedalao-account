package com.xzw.account.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * @author xieziwei
 * @version 2021/8/19
 * @description
 */
@RequestMapping
@Controller
public class IndexController {

    @Value("${server.servlet.context-path}")
    private String accountPath;

    @GetMapping({"/","index"})
    public String index(Model mode){
        return "/index";
    }




}
