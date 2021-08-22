package com.xzw.account.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xieziwei
 * @version 2021/8/22
 * @description 实现登录成功之后的处理类
 */
public class LoginSuccessUrlPageHandel implements AuthenticationSuccessHandler {

    private String redirectUrl;

    public LoginSuccessUrlPageHandel(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 直接重定向到成功页面
        httpServletResponse.sendRedirect(this.redirectUrl);
    }
}
