package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.user.UserActionDTO;
import com.cccs7.co.bean.po.user.UserFollowAction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p> 用户行为转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为转换器
 * @Date 2024/4/9 9:05
 */
@Mapper
public interface UserActionConverter {

    UserActionConverter INSTANCE = Mappers.getMapper(UserActionConverter.class);


    /**
     * dto2po
     *
     * @param userActionDTO 用户行为Dto
     * @return {@link UserFollowAction}
     */
    UserFollowAction dto2po(UserActionDTO userActionDTO);

    /**
     * po2dto
     *
     * @param userFollowAction
     * @return {@link UserActionDTO}
     */
    UserActionDTO po2dto(UserFollowAction userFollowAction);
}
