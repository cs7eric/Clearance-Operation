package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.UserDTO;
import com.cccs7.co.bean.po.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
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
     * 显式地映射User到UserDTO，为id字段指定转换方法
     *  其他字段的映射将保持默认行为
     * @param user 用户
     * @return {@link UserDTO}
     */
    @Mapping(target = "id", source = "id", qualifiedByName = "idToString")
    UserDTO po2dto(User user);


    /**
     * 使用MapStruct的@Named注解定义一个专用于ID转换的方法
     *
     * @param id id
     * @return {@link String}
     */
    @Named("idToString")
    default String mapId(Long id) {
        return id == null ? null : id.toString();
    }
}
