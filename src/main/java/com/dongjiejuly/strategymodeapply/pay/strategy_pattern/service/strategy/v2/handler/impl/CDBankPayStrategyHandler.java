package com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.handler.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.handler.PayStrategyHandler;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.handler.StrategyFactory;
import org.springframework.stereotype.Component;

@Component
public class CDBankPayStrategyHandler implements PayStrategyHandler {

    @Override
    public String pay() {
        return "通过[成都银行]支付通道支付成功";
    }

    // 实现 InitializingBean类 必须实现 afterPropertiesSet() 方法
    @Override
    public void afterPropertiesSet() {
        // 将成都银行支付渠道对象注册到工厂中
        StrategyFactory.register(PayCodeEnum.CD_BANK_PAY.getCode(),this);
    }
}
