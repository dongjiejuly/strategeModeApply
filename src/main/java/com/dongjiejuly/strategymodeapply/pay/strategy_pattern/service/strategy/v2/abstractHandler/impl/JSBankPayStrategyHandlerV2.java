package com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.abstractHandler.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.abstractHandler.AbstractPayStrategyHandler;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.abstractHandler.StrategyFactoryV2;
import org.springframework.stereotype.Component;

@Component
public class JSBankPayStrategyHandlerV2 extends AbstractPayStrategyHandler {
    @Override
    public String pay() {
        return "通过[建设银行]支付通道支付成功";
    }

    @Override
    public String B() {
        return "[建设银行]支付渠道必须调用B()方法处理部分业务逻辑";
    }

    @Override
    public void afterPropertiesSet() {
        StrategyFactoryV2.register(PayCodeEnum.JS_BANK_PAY.getCode(), this);
    }
}
