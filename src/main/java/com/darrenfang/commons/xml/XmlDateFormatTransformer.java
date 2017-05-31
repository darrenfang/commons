package com.darrenfang.commons.xml;

import org.simpleframework.xml.transform.Transform;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * XML 日期转换
 */
public class XmlDateFormatTransformer implements Transform<Date> {
    private DateFormat dateFormat;

    /**
     * 使用指定日期格式创建转换器
     *
     * @param dateFormat 日期格式
     */
    public XmlDateFormatTransformer(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * 将字符串解析为日期
     *
     * @param value 字符串
     * @return 日期
     * @throws ParseException 转换失败时抛出 ParseException
     */
    public Date read(String value) throws ParseException {
        return dateFormat.parse(value);
    }

    /**
     * 将日期格式化为字符串
     *
     * @param value 日期
     * @return 格式化后的字符串
     */
    public String write(Date value) {
        return dateFormat.format(value);
    }

}
