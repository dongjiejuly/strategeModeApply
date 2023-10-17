package com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v1;

public interface IPayStrategyV1Service {

    String pay();

    Boolean isMyself(String type);
}
