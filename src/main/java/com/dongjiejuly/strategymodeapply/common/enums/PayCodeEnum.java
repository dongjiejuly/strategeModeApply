package com.dongjiejuly.strategymodeapply.common.enums;

public enum PayCodeEnum {

    /**
     * 支付宝
     */
    ZFB_PAY("ZFB", "支付宝"),

    /**
     * 微信
     */
    WX_PAY("WX", "微信"),

    /**
     * 成都银行
     */
    CD_BANK_PAY("CD_BANK", "成都银行"),

    /**
     * 工商银行
     */
    GS_BANK_PAY("GS_BANK", "工商银行"),

    /**
     * 建设银行
     */
    JS_BANK_PAY("JS_BANK", "建设银行");

    /**
     * 枚举代码
     */
    private final String code;

    /**
     * 枚举信息
     */
    private final String message;

    PayCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static PayCodeEnum getByCode(String code) {
        if (code == null) {
            return null;
        }

        for (PayCodeEnum payWay : values()) {
            if (code.equals(payWay.getCode())) {
                return payWay;
            }
        }
        return null;
    }

    /**
     * 取值
     *
     * @return String
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 取描述信息
     *
     * @return 描述
     */
    public String getMessage() {
        return this.message;
    }
}
