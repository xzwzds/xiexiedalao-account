package com.xzw.account.entity;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * @author xieziwei
 * @version 2021/8/20
 * @description
 */
@Data
@Table(name = "user")
public class UserInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "birth_day")
    private Date birthDay;

    private String userName;

    private String passWord;

    private String address;

}
