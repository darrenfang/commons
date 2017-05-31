package com.darrenfang.commons.utils;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * SHA 算法工具类
 */
public class SHA {
    /**
     * 转换为 SHA-1 字符串
     *
     * @param src 原始字符串
     * @return SHA-1 字符串
     */
    public static String toSHA1(String src) {
        return getSHAString("SHA-1", src);
    }

    /**
     * 转换为 SHA-224 字符串
     *
     * @param src 原始字符串
     * @return SHA-224 字符串
     */
    public static String toSHA224(String src) {
        return getSHAString("SHA-224", src);
    }

    /**
     * 转换为 SHA-256 字符串
     *
     * @param src 原始字符串
     * @return SHA-256 字符串
     */
    public static String toSHA256(String src) {
        return getSHAString("SHA-256", src);
    }

    /**
     * 转换为 SHA-384 字符串
     *
     * @param src 原始字符串
     * @return SHA-384 字符串
     */
    public static String toSHA384(String src) {
        return getSHAString("SHA-384", src);
    }

    /**
     * 转换为 SHA-512 字符串
     *
     * @param src 原始字符串
     * @return SHA-512 字符串
     */
    public static String toSHA512(String src) {
        return getSHAString("SHA-512", src);
    }

    /**
     * 将字符串转换为对应的 SHA 格式
     *
     * @param messageDigestName 摘要算法名称
     * @param src               原始字符串
     * @return 加密后的字符串
     */
    private static String getSHAString(String messageDigestName, String src) {
        String string = null;

        try {
            MessageDigest sha1 = MessageDigest.getInstance(messageDigestName);
            sha1.reset();
            sha1.update(src.getBytes("UTF-8"));

            string = DatatypeConverter.printHexBinary(sha1.digest());
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }

        return string.toLowerCase(Locale.ENGLISH);
    }
}
