package com.cccs7.co.convert;

import com.cccs7.co.bean.entity.User;
import com.cccs7.co.bean.req.UserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p> User转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description User转换器
 * @Date 2023/10/1 12:41
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE =  Mappers.getMapper(UserConverter.class);

    /**
     * 将userReq 转换为 user
     *
     * @param userReq 用户要求
     * @return {@link User}
     */
    User convertReqToUser(UserReq userReq);
}
