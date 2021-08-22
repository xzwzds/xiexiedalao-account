package com.xzw.account.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description
 */
@Table(name = "tb_permission")
@Data
public class PermissionInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    private String parentId;

    private String name;

    private String enname;

    private String url;

    private String description;

    private Date created;

    private Date updated;

}
