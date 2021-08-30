package com.xzw.account.config;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xieziwei
 * @version 2021/8/23
 * @description
 */
public class MyExpiredSessionStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("当前您已经在别的客户端进行登录");
    }
}
