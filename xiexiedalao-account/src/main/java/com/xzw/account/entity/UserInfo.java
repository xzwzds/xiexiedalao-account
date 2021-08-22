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
@Table(name = "tb_user")
public class UserInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Date created;

    private Date updated;

}
