package com.dongjiejuly.strategymodeapply.strategy.pay.service.original.impl;

import com.dongjiejuly.strategymodeapply.common.enums.PayCodeEnum;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.original.IPayV1Service;
import org.springframework.stereotype.Service;

@Service
public class PayV1ServiceImpl implements IPayV1Service {

    @Override
    public String pay(String type) {

        if (PayCodeEnum.WX_PAY.getCode().equals(type)) {
            return "通过[微信支付]通道支付成功";
        } else if (PayCodeEnum.ZFB_PAY.getCode().equals(type)) {
            return "通过[支付宝支付]通道支付成功";
        } else if (PayCodeEnum.CD_BANK_PAY.getCode().equals(type)) {
            return "通过[成都银行支付]通道支付成功";
        } else {
            return "暂不支持该支付方式";
        }
    }
}
