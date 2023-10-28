package com.cccs7.mybatisplus.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * <p> 批量更新方法 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 批量更新方法
 * @Date 2023/10/27 14:23
 */

public class UpdateBatchMethod extends AbstractMethod {

    /**
     * @since 3.5.0
     */
    public UpdateBatchMethod() {
        super("updateBatch");

    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "<script>\n<foreach collection=\"list\" item=\"item\" separator=\";\">\nupdate %s %s where %s=#{%s} %s\n</foreach>\n</script>";
        String additional = tableInfo.isWithVersion() ? tableInfo.getVersionFieldInfo().getVersionOli("item", "item.") : "" + tableInfo.getLogicDeleteSql(true, true);
        String setSql = sqlSet(tableInfo.isLogicDelete(), false, tableInfo, false, "item", "item.");
        String sqlResult = String.format(sql, tableInfo.getTableName(), setSql, tableInfo.getKeyColumn(), "item." + tableInfo.getKeyProperty(), additional);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
        return this.addUpdateMappedStatement(mapperClass, modelClass, "updateBatch", sqlSource);
    }
}
