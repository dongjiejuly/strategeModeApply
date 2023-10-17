package com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v1.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v1.IPayStrategyV1Service;
import org.springframework.stereotype.Service;

@Service
public class ZFBPayServiceImplStrategy implements IPayStrategyV1Service {

    @Override
    public String pay() {
        return "通过[支付宝支付]通道支付成功";
    }

    @Override
    public Boolean isMyself(String type) {
        return PayCodeEnum.ZFB_PAY.getCode().equals(type);
    }

}
