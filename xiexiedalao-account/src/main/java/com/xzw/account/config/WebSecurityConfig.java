package com.xzw.account.config;

import com.xzw.account.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 权限配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    /**
     * 注入密码编码器
     * @return 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 根据权限管理器,进行权限管理
     * @param auth 权限管理器
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userInfoService);
    }

    /**
     * 实现自定义页面的方式
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//表单提交
        .loginPage("/login/html")//自定义登录页面
        .usernameParameter("userName")
        .passwordParameter("passWord")
        .loginProcessingUrl("/user/login")
                .successHandler(new LoginSuccessUrlPageHandel("/account/success"))
                .failureHandler(new LoginErrorUrlPageHandel("/account/to_error"))
         .and().authorizeRequests() //设置访问权限
        .antMatchers("/user/login","/login/html","/to_error").permitAll() //当前路径下设置为可用进行访问
        .anyRequest().authenticated()//需要进行认证
        .and().csrf().disable();// 关闭csrf防护
    }

    //    基于授权管理器,配置用户详细信息 配置基于内存的用户权限信息
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 密码
//        String passWord = passwordEncoder().encode("xieziwei@123");
//        // 创建基于内存的授权管理器
//        auth.inMemoryAuthentication().withUser("xieziwei").password(passWord).roles("ADMIN")
//                .and().withUser("lichengxi").password(passWord).authorities("ADMIN,USER");
//    }

//    重写加载用户UserDetailService的方式
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        String passWord = passwordEncoder().encode("xieziwei");
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//               return  User.withUsername("lcx").password(passWord).roles("ADMIN").build();
//            }
//        };
//    }

}
