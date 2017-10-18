package com.darrenfang.commons.vo;

import java.util.Date;

/**
 * API 响应
 */
public class ApiResponse {

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 业务代码
     */
    private int status = 200;
    /**
     * 信息
     */
    private String message = "";

    /**
     * 创建默认的 API 响应, 业务代码为 200, 信息为空字符串
     */
    public ApiResponse() {
        this.timestamp = new Date().getTime();
    }

    /**
     * 使用指定的业务代码和信息创建 API 响应
     *
     * @param status  业务代码
     * @param message 信息
     */
    public ApiResponse(int status, String message) {
        this.timestamp = new Date().getTime();
        this.status = status;
        this.message = message;
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * 获取业务代码
     *
     * @return 业务代码
     */
    public int getStatus() {
        return status;
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
