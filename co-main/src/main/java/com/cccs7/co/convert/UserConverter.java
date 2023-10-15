package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.UserDTO;
import com.cccs7.co.bean.po.User;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;
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
     * 将userDTO 转换为 user
     *
     * @param userDTO 用户要求
     * @return {@link User}
     */
    User dto2po(UserDTO userDTO);

    /**
     * 将 User 转换为 UserDTO
     *
     * @param user 用户
     * @return {@link UserDTO}
     */
    UserDTO po2dto(User user);
}
