package com.xzw.account.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xieziwei
 * @version 2021/8/22
 * @description 实现登录失败后的处理类
 */
public class LoginErrorUrlPageHandel implements AuthenticationFailureHandler {
    private String redirectUrl;

    public LoginErrorUrlPageHandel(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(this.redirectUrl);
    }
}
