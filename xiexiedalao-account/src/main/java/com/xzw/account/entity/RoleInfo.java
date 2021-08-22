package com.xzw.account.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 角色信息表
 */
@Table(name = "tb_role")
public class RoleInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    private String parentId;

    private String enname;

    private String description;

    private Date created;

    private Date updated;

}
