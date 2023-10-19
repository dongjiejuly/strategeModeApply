package com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.PayStrategyHandler;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.StrategyFactory;
import org.springframework.stereotype.Component;

@Component
public class ZFBPayStrategyHandler implements PayStrategyHandler {

    @Override
    public String pay() {
        return "通过[支付宝支付]通道支付成功";
    }

    // 实现 InitializingBean类 必须实现 afterPropertiesSet() 方法
    @Override
    public void afterPropertiesSet() {
        StrategyFactory.register(PayCodeEnum.ZFB_PAY.getCode(), this);
    }
}
