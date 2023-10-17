package com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.handler;

import org.springframework.beans.factory.InitializingBean;

/**
 * 策略模式处理接口
 */
public interface PayStrategyHandler extends InitializingBean {

    /**
     * 通用支付方法
     *
     * @return 支付处理结果
     */
    String pay();
}
