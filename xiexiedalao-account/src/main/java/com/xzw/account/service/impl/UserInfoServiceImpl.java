package com.xzw.account.service.impl;

import com.xzw.account.converter.UserConverter;
import com.xzw.account.dao.UserDao;
import com.xzw.account.dto.UserInfoDto;
import com.xzw.account.entity.UserInfo;
import com.xzw.account.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserInfoDto> findAllUserInfo() {
        List<UserInfo> userInfos = userDao.selectAll();
        return userConverter.converterUserInfoList(userInfos);
    }

    @Override
    public int insertUserInfo(UserInfo userInfo) {
        return userDao.insert(userInfo);
    }
}
