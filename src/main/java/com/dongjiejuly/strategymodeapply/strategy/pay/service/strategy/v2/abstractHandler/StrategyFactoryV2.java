package com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.abstractHandler;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactoryV2 {

    public static final Map<String, AbstractPayStrategyHandler> strategyHandlerMap = new HashMap<>();

    public static AbstractPayStrategyHandler getStrategyHandler(String type) {
        return strategyHandlerMap.get(type);
    }

    public static void register(String type, AbstractPayStrategyHandler payStrategyHandler) {
        strategyHandlerMap.put(type, payStrategyHandler);
    }
}
