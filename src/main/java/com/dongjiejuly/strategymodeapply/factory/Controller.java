package com.dongjiejuly.strategymodeapply.factory;

import com.dongjiejuly.strategymodeapply.strategy.pay.service.strategy.v2.handler.PayStrategyHandler;

import java.util.Objects;

public class Controller {

    // 简单模拟客户端请求，请求不同支付渠道完成不同支付渠道的支付动作
    public static void pay(String type){
        PayStrategyHandler strategyHandler = FactoryV1.getStrategyHandler(type);
        if (Objects.nonNull(strategyHandler)) {
            String pay = strategyHandler.pay();
            System.out.println(pay);
        }else{
            System.out.println("不支持当前支付通道");
        }
    }

    public static void main(String[] args) {
        pay("WX");
    }
}
