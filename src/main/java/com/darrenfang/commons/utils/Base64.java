package com.darrenfang.commons.utils;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

/**
 * base64 编码工具类
 */
public class Base64 {

    /**
     * base64 编码
     *
     * @param src 待转换的字符串
     * @return base64 编码后的字符串
     */
    public static String toString(String src) {
        String string = null;
        try {
            string = DatatypeConverter.printBase64Binary(src.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }

        return string;
    }

    /**
     * base64 解码为字节数组
     *
     * @param base64String base64 字符串
     * @return 字节数组
     */
    public static byte[] parseBytes(String base64String) {
        return DatatypeConverter.parseBase64Binary(base64String);
    }

    /**
     * base64 解码
     *
     * @param base64String base64 字符串
     * @return 解码后的字符串
     */
    public static String parseString(String base64String) {
        String string = null;
        try {
            string = new String(DatatypeConverter.parseBase64Binary(base64String), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return string;
    }
}
