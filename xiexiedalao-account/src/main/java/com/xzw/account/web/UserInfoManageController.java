package com.xzw.account.web;

import com.xzw.account.dto.UserInfoDto;
import com.xzw.account.entity.UserInfo;
import com.xzw.account.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 用户信息管理
 */
@RestController
public class UserInfoManageController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/user/add")
    public void addUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("谢子威");
        userInfo.setAddress("湖北省");
        userInfo.setBirthDay(new Date());
        userInfo.setPassWord("123456");
        userInfoService.insertUserInfo(userInfo);
    }

    @GetMapping("/user/all")
    public List<UserInfoDto> findUserInfo(){
        return userInfoService.findAllUserInfo();
    }

}
