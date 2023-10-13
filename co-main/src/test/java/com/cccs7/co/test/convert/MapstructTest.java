package com.cccs7.co.test.convert;

import com.cccs7.co.bean.dto.UserDTO;
import com.cccs7.co.bean.po.User;
import com.cccs7.co.convert.UserConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p> mapstruct测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description mapstruct测试类
 * @Date 2023/10/12 11:15
 */
@SpringBootTest
public class MapstructTest {

    @Test
    public void testMapstruct() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("qqq");
        userDTO.setCode("2323");
        userDTO.setNickName("test");
        User user = UserConverter.INSTANCE.dto2po(userDTO);
        System.out.println(user);

    }
}
