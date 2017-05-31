package com.darrenfang.commons.utils;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * MD5 工具类
 */
public class MD5 {

    /**
     * 将字符串转换为 MD5 小写字符串
     *
     * @param src 原始字符串
     * @return MD5 小写字符串
     */
    public static String toLowerCase(String src) {

        String md5 = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(src.getBytes("UTF-8"));
            md5 = DatatypeConverter.printHexBinary(md.digest());
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }

        return md5.toLowerCase(Locale.ENGLISH);
    }

    /**
     * 将字符串转换为 MD5 大写字符串
     *
     * @param src 原始字符串
     * @return MD5 大写字符串
     */
    public static String toUpperCase(String src) {
        return toLowerCase(src).toUpperCase(Locale.ENGLISH);
    }
}
