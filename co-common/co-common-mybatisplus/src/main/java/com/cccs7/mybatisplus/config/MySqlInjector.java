package com.cccs7.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.cccs7.mybatisplus.method.UpdateBatchMethod;

import java.util.List;

/**
 * SQL注入器
 * <p> sql注入器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description sql注入器
 * @Date 2023/10/27 10:18
 */
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        // super.getMethodList() 保留 Mybatis Plus 自带的方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        // 添加自定义方法：批量插入，方法名为 insertBatchSomeColumn
        methodList.add(new UpdateBatchMethod());
        methodList.add(new InsertBatchSomeColumn());
        return methodList;
    }


}
