package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cccs7.co.bean.po.cases.FraudCase;
import com.cccs7.co.bean.po.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p> UserMapper 接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description UserMapper 接口
 * @Date 2023/9/13 23:09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 随机查询指定数量的用户
     *
     * @param limit 限制
     * @return {@link List}<{@link FraudCase}>
     */
    @Select("SELECT * FROM `sys_user` ORDER BY RAND() LIMIT #{limit}")
    List<User> selectRandom(Integer limit);


    IPage<User> searchUsersFuzzy(Page<User> page, @Param("keyword") String keyword);

    /**
     * 更新关注数
     *
     * @param userId    用户id
     * @param increment 增量
     */
    @Update("UPDATE `sys_user` SET follows_num = follows_num + #{increment} WHERE id = #{userId}")
    void updateFollowNum(@Param("userId") Long userId, @Param("increment") int increment);
}
