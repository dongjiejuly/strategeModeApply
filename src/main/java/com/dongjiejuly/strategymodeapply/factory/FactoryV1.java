package com.dongjiejuly.strategymodeapply.factory;

import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.PayStrategyHandler;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.impl.WXPayStrategyHandler;
import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.impl.ZFBPayStrategyHandler;

public class FactoryV1 {

    /**
     * 工厂中获取实例的方法：
     * 通过if else的简单处理，如果涉及新增支付渠道则需要修改代码
     *
     * @param type 请求获取实例类型
     * @return 返回支付通道实例
     */
    public static PayStrategyHandler getStrategyHandler(String type) {
        if (type.equals("ZFB")) {
            return new ZFBPayStrategyHandler();
        } else if (type.equals("WX")) {
            return new WXPayStrategyHandler();
        } else {
            return null;
        }
    }
}
