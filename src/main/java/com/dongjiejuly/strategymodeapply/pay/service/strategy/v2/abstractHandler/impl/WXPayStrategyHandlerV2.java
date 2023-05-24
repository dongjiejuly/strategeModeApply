package com.dongjiejuly.strategymodeapply.pay.service.strategy.v2.abstractHandler.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.pay.service.strategy.v2.abstractHandler.AbstractPayStrategyHandler;
import com.dongjiejuly.strategymodeapply.pay.service.strategy.v2.abstractHandler.StrategyFactoryV2;
import org.springframework.stereotype.Component;

@Component
public class WXPayStrategyHandlerV2 extends AbstractPayStrategyHandler {

    @Override
    public String pay() {
        return "通过[微信支付]通道支付成功";
    }

    // 实现 InitializingBean类 必须实现 afterPropertiesSet() 方法
    @Override
    public void afterPropertiesSet() {
        StrategyFactoryV2.register(PayCodeEnum.WX_PAY.getCode(),this);
    }
}
