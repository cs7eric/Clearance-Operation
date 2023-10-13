package com.cccs7.co.test.convert;

import com.cccs7.co.bean.dto.ArticleDTO;
import com.cccs7.co.bean.dto.UserDTO;
import com.cccs7.co.bean.po.Article;
import com.cccs7.co.bean.po.User;
import com.cccs7.co.convert.ArticleConverter;
import com.cccs7.co.convert.UserConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p> mapstruct测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description mapstruct测试类
 * @Date 2023/10/12 11:15
 */
@Slf4j
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

    @Test
    public void testMapstruct1() {

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setAuthor("cccs7");
        articleDTO.setLikes(111);
        articleDTO.setReplyNum(23);
        Article article = ArticleConverter.INSTANCE.dto2po(articleDTO);
        log.info("article:{}", article);
    }
}
