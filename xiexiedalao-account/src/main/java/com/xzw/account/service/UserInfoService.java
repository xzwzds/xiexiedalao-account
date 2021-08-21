package com.xzw.account.service;

import com.xzw.account.converter.UserConverter;
import com.xzw.account.dao.UserDao;
import com.xzw.account.dto.UserInfoDto;
import com.xzw.account.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description
 */
public interface UserInfoService {
    /**
     * 查询所有用户信息
     * @return 返回所有用户信息
     */
    List<UserInfoDto> findAllUserInfo();

    /**
     * 插入用户数据
     * @param userInfo
     * @return
     */
    int insertUserInfo(UserInfo userInfo);


}
