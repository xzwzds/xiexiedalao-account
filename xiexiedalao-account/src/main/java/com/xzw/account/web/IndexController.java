package com.xzw.account.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    private String getUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails){
                return ((UserDetails) principal).getUsername();
            }else {
                return principal.toString();
            }
        }
        return "无法获取到用户人员";
    }

    @GetMapping({"/","index"})
    public String index(Model mode){
        String userInfo = getUserInfo();
        mode.addAttribute("userName",userInfo);
        return "/index";
    }

    @GetMapping("/login/html")
    public String login(){
        return "/login/login";
    }




}
