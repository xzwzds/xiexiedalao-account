package com.xzw.account;

import com.xzw.account.test.MyCustomAuthenticationManager;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xieziwei
 * @version 2021/8/25
 * @description 测试认证流程
 */
public class TestAuthenticationExample {

    static MyCustomAuthenticationManager myCustomAuthenticationManager = new MyCustomAuthenticationManager();

    public static void main(String[] args) throws IOException {

        // 读输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("输入你的名字");
            String username = bufferedReader.readLine();
            System.out.println("输入你的密码");
            String password = bufferedReader.readLine();
            try{
                // 封装认证信息
                Authentication authentication = new UsernamePasswordAuthenticationToken(username,password);
                // 进行认证处理
                Authentication authenticate = myCustomAuthenticationManager.authenticate(authentication);
                // 当前线程保定授权用户
                SecurityContextHolder.getContext().setAuthentication(authenticate);
                break;
            }catch (AuthenticationException e){
                System.out.println("Authenticated failed:"+e.getLocalizedMessage());
            }
        }
        System.out.println("认证成功:"+SecurityContextHolder.getContext().getAuthentication());

    }






}
