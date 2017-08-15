package com.darrenfang.commons.mobile;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>手机号码工具类</p>
 * 中国移动：134（不含1349）、135、136、137、138、139、147、150、151、152、157、158、 159、182、183、184、187、188、178 <br>
 * 中国联通：130、131、132、145（上网卡）、155、156、185、186、176、175 <br>
 * 中国电信：133、1349（卫星通信）、153、180、181、189、177、173、149 <br>
 * 4G号段：176/175(联通)、173/177(电信)、178(移动) <br>
 * 虚拟运营商：170[1700/1701/1702(电信)、1703/1705/1706(移动)、1704/1707/1708/1709(联通)]、171（联通） <br>
 */
public class Mobile {

    /**
     * 手机号码正则表达式
     */
    private static Pattern mobilePattern = Pattern
            .compile("1(3[0-9]{9}|4[579][0-9]{8}|5[0-35-9][0-9]{8}|7[0135678][0-9]{8}|8[0-9]{9})");

    /**
     * 移动号码正则表达式
     */
    private static Pattern cmccPattern = Pattern
            .compile("^1(34[0-8][0-9]{7}|3[5-9][0-9]{8}|47[0-9]{8}|5[012789][0-9]{8}|70[356][0-9]{7}|78[0-9]{8}|8[23478][0-9]{8})$");
    /**
     * 联通号码正则表达式
     */
    private static Pattern unicomPattern = Pattern
            .compile("^1(3[0-2][0-9]{8}|45[0-9]{8}|5[56][0-9]{8}|70[4789][0-9]{7}|7[156][0-9]{8}|8[56][0-9]{8})$");
    /**
     * 电信号码正则表达式
     */
    private static Pattern telecomPattern = Pattern
            .compile("^1(33[0-9]{8}|349[0-9]{7}|49[0-9]{8}|53[0-9]{8}|70[012][0-9]{7}|7[37][0-9]{8}|8[019][0-9]{8})$");

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
        return typeOf(mobile) != MobileType.UNKNOWN;
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

}