package com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.abstractHandler.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.abstractHandler.StrategyFactoryV2;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.abstractHandler.AbstractPayStrategyHandler;
import org.springframework.stereotype.Component;

/**
 * 模拟工商银行支付渠道
 * 工商银行支付渠道需要调用A()方法
 */
@Component
public class GSBankPayStrategyHandlerV2 extends AbstractPayStrategyHandler {

    @Override
    public String pay() {
        return "通过[工商银行]支付通道支付成功";
    }

    @Override
    public String A() {
        return "[工商银行]支付渠道必须调用A()方法处理部分业务逻辑";
    }

    @Override
    public void afterPropertiesSet() {
        StrategyFactoryV2.register(PayCodeEnum.GS_BANK_PAY.getCode(),this);
    }
}
