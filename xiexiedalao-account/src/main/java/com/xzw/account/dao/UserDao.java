package com.xzw.account.dao;

import com.xzw.account.entity.UserInfo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author xieziwei
 * @version 2021/8/20
 * @description 用户信息数据访问层
 */
@Component
public interface UserDao extends Mapper<UserInfo> {

}
