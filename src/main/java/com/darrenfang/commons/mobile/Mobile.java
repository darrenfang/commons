package com.darrenfang.commons.mobile;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>手机号码工具类</p>
 * https://zh.wikipedia.org/wiki/%E4%B8%AD%E5%9B%BD%E5%86%85%E5%9C%B0%E7%A7%BB%E5%8A%A8%E7%BB%88%E7%AB%AF%E9%80%9A%E8%AE%AF%E5%8F%B7%E6%AE%B5
 */
public class Mobile {

    /**
     * 手机号码正则表达式
     */
    private static Pattern mobilePattern = Pattern
            .compile("1(3[0-9]{9}|4[579][0-9]{8}|5[0-35-9][0-9]{8}|6[67][0-9]{8}|7[0135678][0-9]{8}|8[0-9]{9}|9[189][0-9]{8})");

    /**
     * 移动号码正则表达式
     */
    private static Pattern cmccPattern = Pattern
            .compile("^1(34[0-8][0-9]{7}|3[5-9][0-9]{8}|47[0-9]{8}|5[012789][0-9]{8}|70[356][0-9]{7}|78[0-9]{8}|8[23478][0-9]{8}|98[0-9]{8})$");
    /**
     * 联通号码正则表达式
     */
    private static Pattern unicomPattern = Pattern
            .compile("^1(3[0-2][0-9]{8}|45[0-9]{8}|5[56][0-9]{8}|6[67][0-9]{8}|70[4789][0-9]{7}|7[156][0-9]{8}|8[56][0-9]{8})$");
    /**
     * 电信号码正则表达式
     */
    private static Pattern telecomPattern = Pattern
            .compile("^1(33[0-9]{8}|349[0-9]{7}|49[0-9]{8}|53[0-9]{8}|70[012][0-9]{7}|7[37][0-9]{8}|8[019][0-9]{8}|9[19][0-9]{8})$");

    /**
     * 判断手机号码格式是否正确
     *
     * @param mobile 手机号码
     * @return 如果格式正确返回 true, 否则返回 false
     */
    public static boolean isMobile(String mobile) {
        if (StringUtils.isBlank(mobile) || mobile.length() != 11) {
            return false;
        }
        return mobilePattern.matcher(mobile).matches();
    }

    /**
     * 获取手机号码运营商类型
     *
     * @param mobile 手机号码
     * @return 运营商类型
     */
    public static MobileType typeOf(String mobile) {
        if (StringUtils.isBlank(mobile) || mobile.length() != 11) {
            return MobileType.UNKNOWN;
        }

        if (cmccPattern.matcher(mobile).matches()) {
            return MobileType.CMCC;
        }

        if (unicomPattern.matcher(mobile).matches()) {
            return MobileType.UNICOM;
        }

        if (telecomPattern.matcher(mobile).matches()) {
            return MobileType.TELECOM;
        }

        return MobileType.UNKNOWN;
    }

    /**
     * 从字符串中获取所有的手机号码
     *
     * @param string 字符串
     * @return 手机号码集合
     */
    public static Set<String> parse(String string) {

        Set<String> mobiles = new HashSet<String>();

        if (StringUtils.isBlank(string)) {
            return mobiles;
        }

        Matcher matcher = mobilePattern.matcher(string);
        while (matcher.find()) {
            mobiles.add(matcher.group());
        }
        return mobiles;
    }

    /**
     * 过滤手机号码
     *
     * @param mobiles 需要过滤的手机号码集合
     * @return 手机号码集合
     */
    public static Set<String> filter(Collection<String> mobiles) {
        Set<String> result = new HashSet<>();
        for (String mobile : mobiles) {
            if (isMobile(mobile)) {
                result.add(mobile);
            }
        }
        return result;
    }

}