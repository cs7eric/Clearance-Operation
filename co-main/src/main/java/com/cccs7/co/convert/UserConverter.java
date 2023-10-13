package com.cccs7.co.convert;

import com.cccs7.co.bean.entity.User;
import com.cccs7.co.bean.req.UserReq;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

/**
 * <p> User转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description User转换器
 * @Date 2023/10/1 12:41
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    UserConverter INSTANCE =  Mappers.getMapper(UserConverter.class);

    /**
     * 将userReq 转换为 user
     *
     * @param userReq 用户要求
     * @return {@link User}
     */
    @SubclassMapping(source = UserReq.class, target = User.class)
    User convertReqToUser(UserReq userReq);
}
