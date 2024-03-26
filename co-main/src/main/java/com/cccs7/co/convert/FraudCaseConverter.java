package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.cases.FraudCaseDTO;
import com.cccs7.co.bean.po.cases.FraudCase;
import org.mapstruct.factory.Mappers;

/**
 * <p> fraud case 转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description fraud case 转换器
 * @Date 2024/3/26 22:34
 */
public interface FraudCaseConverter {


    FraudCaseConverter INSTANCE = Mappers.getMapper(FraudCaseConverter.class);

    /**
     * po2dto
     *
     * @param fraudCase fraudCase
     * @return {@link FraudCaseDTO}
     */
    FraudCaseDTO po2dto(FraudCase fraudCase);

    /**
     * dto2po
     *
     * @param fraudCaseDTO fraudCaseDTO
     * @return {@link FraudCase}
     */
    FraudCase dto2po(FraudCaseDTO fraudCaseDTO);
}
