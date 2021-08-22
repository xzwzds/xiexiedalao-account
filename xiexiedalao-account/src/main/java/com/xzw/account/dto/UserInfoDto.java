package com.xzw.account.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 用户信息数据传输对象
 */
@Data
public class UserInfoDto {

    private String id;

    private Date birthDay;

    private String passWord;

    private String userName;

    private String local;
}
