package com.cccs7.co.service;

import com.cccs7.co.bean.dto.UserActionDTO;
import com.cccs7.co.bean.po.UserArticleAction;
import com.cccs7.co.enums.UserActionType;

/**
 * <p> 用户行为接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为接口
 * @Date 2023/10/25 23:57
 */
public interface UserActionService {

    /**
     * 执行用户行为
     *
     * @param userActionDTO 用户行为Dto
     */
    void doAction(UserActionDTO userActionDTO);
}
