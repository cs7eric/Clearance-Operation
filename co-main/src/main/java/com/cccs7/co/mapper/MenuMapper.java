package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccs7.co.bean.po.user.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单mapper
 *
 * @Author cccs7
 * @Date 2023/09/15
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     *  根据用户 ID 查询所有权限
     * @param id 用户 ID
     * @return {@link List}<{@link String}>
     */
    List<String> selectPermsByUserId(Long id);
}
