package com.xzw.account.service;

import com.xzw.account.entity.PermissionInfo;
import java.util.List;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 授权信息查询
 */
public interface PermissionInfoService {

    /**
     * 根据用户名称查询权限信息集合
     * @param userName
     * @return
     */
    List<PermissionInfo> findPermissionInfoByUserId(String userName);


}
