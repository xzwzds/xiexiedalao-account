package com.xzw.account.config;

import com.xzw.account.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 权限配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;


    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }



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
        .usernameParameter("userName") // 自定义表单提交值
        .passwordParameter("passWord") //
        .loginProcessingUrl("/user/login")
//                .defaultSuccessUrl("/success")
        .successForwardUrl("/success") // 使用当前接口必须是Post方法
        .failureForwardUrl("/to_error") // 当前接口必须是Post方法
//        .successHandler(new LoginSuccessUrlPageHandel("/account/success"))
//        .failureHandler(new LoginErrorUrlPageHandel("/account/to_error"))
        .and().authorizeRequests() //设置访问权限
        .antMatchers("/user/login","/login/html","/to_error").permitAll() //当前路径下设置为可用进行访问
        .anyRequest().authenticated()//需要进行认证
        .and().csrf().disable();// 关闭csrf防护
        // 配置Session管理器策略
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .invalidSessionUrl("/to_error")
        .maximumSessions(1) // 设置登录次数只能是 1个人
        .expiredSessionStrategy(new MyExpiredSessionStrategy()); // 并发多人登录之后的处理方式
        //.maxSessionsPreventsLogin(true);//不允许多人登录 - 传递的是一个Boolean值 - 一旦配置不允许其余人进行登录就会前面的配置

        // 记住我配置
        http.rememberMe()
                .tokenRepository(new InMemoryTokenRepositoryImpl()) //实现记住我实现方式,提供两种,一种是JDBC一种是基于内存
                .tokenValiditySeconds(300) // 设置存储时间- 默认是 2周
                .userDetailsService(userInfoService); // 自定义登录逻辑

        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");


        //http.authorizeRequests().antMatchers("/account/admin/demo").hasAnyRole("admin");

        // 无权限访问
        http.exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());

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
