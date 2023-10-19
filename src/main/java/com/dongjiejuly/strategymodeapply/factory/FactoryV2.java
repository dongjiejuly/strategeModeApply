package com.dongjiejuly.strategymodeapply.factory;

import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.PayStrategyHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类
 */
public class FactoryV2 {

    public static final Map<String, PayStrategyHandler> strategyHandlerMap = new HashMap<>();

    /**
     * 工厂中获取实例的方法
     * 通过实现类自动装配的方式，新增一个支付通道，只需要在该支付通道里面调用工程的register方法注入到工厂的map中即可
     *
     * @param type 请求获取实例类型
     * @return 返回实例
     */
    public static PayStrategyHandler getStrategyHandler(String type) {
        return strategyHandlerMap.get(type);
    }

    /**
     * 各个策略实例在程序启动的时候调用register()方法将自身实例注册到工厂中
     *
     * @param type               类型
     * @param payStrategyHandler 具体实例
     */
    public static void register(String type, PayStrategyHandler payStrategyHandler) {
        strategyHandlerMap.put(type, payStrategyHandler);
    }
}
