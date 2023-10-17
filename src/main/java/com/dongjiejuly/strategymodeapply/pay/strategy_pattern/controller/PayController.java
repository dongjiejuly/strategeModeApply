package com.dongjiejuly.strategymodeapply.pay.strategy_pattern.controller;

import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.original.IPayV1Service;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v1.IPayStrategyV1Service;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.abstractHandler.AbstractPayStrategyHandler;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.abstractHandler.StrategyFactoryV2;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.handler.PayStrategyHandler;
import com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.handler.StrategyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class PayController {

    @Resource
    private IPayV1Service payService;

    @Resource
    private List<IPayStrategyV1Service> payStrategyV1Service;

    /**
     * http://127.0.0.1:8080/v1/pay?type=WX
     * 原始方法，不使用策略模式的情况下的代码
     *
     * @param type 支付类型
     * @return 返回支付结果
     */
    @GetMapping("/v1/pay")
    @ResponseBody
    public String payOriginal(@RequestParam(name = "type") String type) {
        return payService.pay(type);
    }

    /**
     * http://127.0.0.1:8080/v2/pay?type=ZFB
     * 使用【简单策略模式】的情况下的代码
     *  该种策略模式通过List<IPayStrategyV1Service>注入的模式，将所有注入的实现了通过filter找到匹配的实现了，调用
     *  对应的实现方法即可
     *
     * @param type 支付类型
     * @return 返回支付结果
     */
    @GetMapping("/v2/pay")
    @ResponseBody
    public String payStrategyV2(@RequestParam(name = "type") String type) {
        List<IPayStrategyV1Service> collect = payStrategyV1Service.stream().filter(t -> t.isMyself(type))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect)) {
            return "暂不支持该支付方式";
        }
        return collect.get(0).pay();
    }

    /**
     * http://127.0.0.1:8080/v3/pay?type=ZFB
     * 使用【策略模式 + 工厂模式】的情况下的代码
     *  通过工厂模式实现策略的获取和生产(主要是策略实现类调用工厂进行注册)
     *  通过策略模式实现各自不同算法
     *
     * @param type 支付类型
     * @return 返回支付结果
     */
    @GetMapping("/v3/pay")
    @ResponseBody
    public String payStrategyV3(@RequestParam(name = "type") String type) {

        // 通过工厂获取到对应的策略类对象
        PayStrategyHandler strategyHandler = StrategyFactory.getStrategyHandler(type);
        if(Objects.isNull(strategyHandler)){
            return "暂不支持该支付方式";
        }

        // 调用不同策略算法完成业务功能
        return strategyHandler.pay();
    }

    /**
     * http://127.0.0.1:8080/v4/pay?type=ZFB
     * 使用【策略模式 + 工厂模式 + 模版模式】的情况下的代码
     *  通过工厂模式实现策略的获取和生产(主要是策略实现类调用工厂进行注册)
     *  通过策略模式实现各自不同算法
     *  通过模版模式（抽象类的方式）是的每个方法都有默认实现，用于处理不同策略可能存在不同调用的情况
     *
     * @param type 支付类型
     * @return 返回支付结果
     */
    @GetMapping("/v4/pay")
    @ResponseBody
    public String payStrategyV4(@RequestParam(name = "type") String type) {

        // 通过工厂获取到对应的策略类对象
        AbstractPayStrategyHandler strategyHandler = StrategyFactoryV2.getStrategyHandler(type);
        if(Objects.isNull(strategyHandler)){
            return "暂不支持该支付方式";
        }
        // 调用不同策略算法完成业务功能
        return strategyHandler.pay();
    }
}
