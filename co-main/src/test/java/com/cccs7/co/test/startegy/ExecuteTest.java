package com.cccs7.co.test.startegy;

import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.service.impl.DynamicLabelOperationServiceImpl;
import com.cccs7.co.service.impl.TagServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p> s </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description s
 * @Date 2024/3/21 23:40
 */
@SpringBootTest
public class ExecuteTest {

    @Autowired
    private DynamicLabelOperationServiceImpl dynamicLabelOperationService;


    @Autowired
    private TagServiceImpl tagService;

    @Test
    public void testExecute() {
        String label = "Category";
        String operation = "List";

        List<Tag> tagList = tagService.list();
        tagList.forEach(System.out::println);
    }
}
