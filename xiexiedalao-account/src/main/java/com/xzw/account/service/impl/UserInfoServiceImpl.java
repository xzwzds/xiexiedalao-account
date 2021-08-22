package com.xzw.account.service.impl;

import com.xzw.account.converter.UserConverter;
import com.xzw.account.dao.UserDao;
import com.xzw.account.dto.UserInfoDto;
import com.xzw.account.entity.PermissionInfo;
import com.xzw.account.entity.UserInfo;
import com.xzw.account.service.PermissionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PermissionInfoService permissionInfoService;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    public UserInfo findUserInfoByUserName(String userName){
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("username",userName);
        List<UserInfo> userInfos = userDao.selectByExample(example);
        if (!CollectionUtils.isEmpty(userInfos)){
            return userInfos.get(0);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = findUserInfoByUserName(userName);
        // 查询用户信息
        if (userInfo != null){
        // 创建获取权限信息集合
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        // 根据用户获取权限信息
        List<PermissionInfo> permissionInfoList = permissionInfoService.findPermissionInfoByUserId(userInfo.getId());
        if (!CollectionUtils.isEmpty(permissionInfoList)){
            for (PermissionInfo permissionInfo : permissionInfoList) {
                if (permissionInfo != null && StringUtils.isEmpty(permissionInfo.getEnname())){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissionInfo.getEnname());
                    grantedAuthorityList.add(grantedAuthority);
                }
            }
        }
        // 处理信息
        return new User(userInfo.getUsername(),userInfo.getPassword(),grantedAuthorityList);
        }else {
            throw new IllegalStateException("无法查询到角色");
        }
    }
}
