package com.dongjiejuly.strategymodeapply.pay.strategy_pattern.service.strategy.v2.abstractHandler;

import org.springframework.beans.factory.InitializingBean;

public abstract class AbstractPayStrategyHandler implements InitializingBean {

    public String pay() {
        throw new UnsupportedOperationException();
    }

    /**
     * 在抽象类中有默认的A()方法实现，工商银行需要走A()方法调用，只需要工商银行实现类实现该方法接口，
     * 其他支付渠道则无需实现该方法
     *
     * @return 返回结果
     */
    public String A() {
        throw new UnsupportedOperationException();
    }

    /**
     * 在抽象类中有默认的B()方法实现，建设银行需要走B()方法调用，只需要建设银行实现类实现该方法接口，
     * 其他支付渠道则无需实现该方法
     *
     * @return 返回结果
     */
    public String B() {
        throw new UnsupportedOperationException();
    }
}
