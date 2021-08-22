package com.xzw.account.dao;

import com.xzw.account.entity.PermissionInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 授权信息数据访问层
 */
public interface PermissionDao extends Mapper<PermissionInfo> {


    /**
     * 根据查询用户名查询所有当前用户的权限信息
     * @param userId 用户名
     * @return 返回所有的权限信息
     */
    List<PermissionInfo> findPermissionInfoByUserId(String userId);



}
