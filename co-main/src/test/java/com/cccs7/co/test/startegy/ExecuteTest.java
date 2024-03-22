package com.cccs7.co.test.startegy;

import com.cccs7.co.service.impl.DynamicLabelOperationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    public void testExecute() {
        String label = "Tag";
        String operation = "List";

        dynamicLabelOperationService.performOperation(label, operation);
    }
}
