package com.cccs7.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.cccs7.mybatisplus.interceptor.SqlBeautyInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CSQ-PC
 */
@Configuration
public class MybatisPlusConfiguration {


    @Bean
    @ConditionalOnProperty(name = {"sql.beauty.show"}, havingValue = "true", matchIfMissing = true)
    public SqlBeautyInterceptor sqlBeautyInterceptor() {
        return new SqlBeautyInterceptor();
    }


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    /**
     * sql注入器
     * @return InsertBatchSqlInjector
     */
    @Bean
    public MySqlInjector sqlInjector() {
        return new MySqlInjector();
    }

}
