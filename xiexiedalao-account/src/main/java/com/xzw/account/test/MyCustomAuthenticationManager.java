package com.xzw.account.test;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

/**
 * @author xieziwei
 * @version 2021/8/25
 * @description
 */
public class MyCustomAuthenticationManager implements AuthenticationManager {

    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getName().equals(authentication.getCredentials())){
            return new UsernamePasswordAuthenticationToken(authentication.getName(),authentication.getCredentials(),AUTHORITIES);
        }
       throw new BadCredentialsException("Bad Credentials");
    }
}
