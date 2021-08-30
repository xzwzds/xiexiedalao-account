package com.xzw.account.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xieziwei
 * @version 2021/8/29
 * @description
 */
public class MyAccessDeniedHandler  implements AccessDeniedHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("权限不足,请授权后重置");
        out.flush();
        // 关闭流
        out.close();
    }
}
