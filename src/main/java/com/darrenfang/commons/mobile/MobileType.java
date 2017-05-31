package com.darrenfang.commons.mobile;

/**
 * 手机号码运营商类别
 */
public enum MobileType {
    /**
     * 未知
     */
    UNKNOWN("未知"),
    /**
     * 中国移动
     */
    CMCC("中国移动"),
    /**
     * 中国联通
     */
    UNICOM("中国联通"),
    /**
     * 中国电信
     */
    TELECOM("中国电信");

    /**
     * 运营商名称
     */
    private String name;

    /**
     * 实例化运营商类别
     *
     * @param name 运营商名称
     */
    MobileType(String name) {
        this.name = name;
    }

    /**
     * 获取运营商名称
     *
     * @return 运营商名称
     */
    public String getName() {
        return name;
    }
}
