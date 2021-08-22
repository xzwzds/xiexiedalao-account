package com.xzw.account.converter;

import com.xzw.account.dto.UserInfoDto;
import com.xzw.account.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author xieziwei
 * @version 2021/8/21
 * @description 用户信息转换Dto
 */
@Mapper(componentModel = "spring")
public interface UserConverter {
//
//    /**
//     * 实体类信息转换
//     * @param userInfo 用户信息
//     * @return
//     */
//    @Mappings({
//           @Mapping(source = "address",target = "local"),
//           @Mapping(source = "birthDay",target = "birthDay",dateFormat = "yyyy-MM-dd HH:mm:ss"),
//           @Mapping(target = "passWord",ignore = true)
//    })
//    UserInfoDto converterUserInfo(UserInfo userInfo);
//
//    /**
//     * 实体类转换 集合类型
//     * @param userInfoList 用户信息集合
//     * @return
//     */
//    List<UserInfoDto> converterUserInfoList(List<UserInfo> userInfoList);

}
