package com.cccs7.co.test.convert;

import com.cccs7.co.bean.entity.User;
import com.cccs7.co.bean.req.UserReq;
import com.cccs7.co.convert.UserConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserReq userReq = new UserReq();
        userReq.setEmail("qqq");
        userReq.setCode("2323");
        User user = new User();
        user = UserConverter.INSTANCE.convertReqToUser(userReq);
        System.out.println(user);

    }
}
