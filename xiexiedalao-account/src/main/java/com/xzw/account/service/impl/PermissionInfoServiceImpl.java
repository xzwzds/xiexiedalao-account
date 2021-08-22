package com.xzw.account.service.impl;

import com.xzw.account.dao.PermissionDao;
import com.xzw.account.entity.PermissionInfo;
import com.xzw.account.service.PermissionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xieziwei
 * @version 2021/8/21
 * @description
 */
@Service
public class PermissionInfoServiceImpl implements PermissionInfoService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<PermissionInfo> findPermissionInfoByUserId(String userId) {
        return permissionDao.findPermissionInfoByUserId(userId);
    }
}
