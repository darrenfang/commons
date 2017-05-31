package com.darrenfang.commons.web;

/**
 * 视图模型
 */
public class ViewModel {

    /**
     * 业务代码
     */
    private int code = 200;
    /**
     * 信息
     */
    private String message = "";

    /**
     * 创建默认的视图模型, 业务代码为 200, 信息为空字符串
     */
    public ViewModel() {
    }

    /**
     * 使用指定的业务代码和信息创建视图模型
     *
     * @param code    业务代码
     * @param message 信息
     */
    public ViewModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取业务代码
     *
     * @return 业务代码
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取信息
     *
     * @return 信息
     */
    public String getMessage() {
        return message;
    }
}
