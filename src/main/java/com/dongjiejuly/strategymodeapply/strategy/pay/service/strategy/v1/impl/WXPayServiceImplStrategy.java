package com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v1.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v1.IPayStrategyV1Service;
import org.springframework.stereotype.Service;

@Service
public class WXPayServiceImplStrategy implements IPayStrategyV1Service {

    @Override
    public String pay() {
        return "通过[微信支付]通道支付成功";
    }

    @Override
    public Boolean isMyself(String type) {
        return PayCodeEnum.WX_PAY.getCode().equals(type);
    }
}
