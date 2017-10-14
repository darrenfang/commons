package com.darrenfang.commons.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 时间工具类
 */
public final class DateTime {
    /***
     * 将 LocalDateTime 转换为 Date
     * @param localDateTime localDateTime
     * @return 转换后的 Date
     */
    public static Date from(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /***
     * 将 Date 转换为 LocalDateTime
     * @param date date
     * @return 转换后的 LocalDateTime
     */
    public static LocalDateTime from(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
