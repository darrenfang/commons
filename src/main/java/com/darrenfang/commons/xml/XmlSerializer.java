package com.darrenfang.commons.xml;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * XML 序列化器, 提供序列化和反序列化功能
 */
public class XmlSerializer {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private Serializer serializer;

    /**
     * 使用默认的日期格式（yyyy-MM-dd HH:mm:ss）创建序列化器
     */
    public XmlSerializer() {
        this(DEFAULT_DATE_FORMAT);
    }

    /**
     * 使用指定的日期格式创建序列化器
     *
     * @param dateFormat 日期格式
     */
    public XmlSerializer(String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        RegistryMatcher registryMatcher = new RegistryMatcher();
        registryMatcher.bind(Date.class, new XmlDateFormatTransformer(format));
        serializer = new Persister(registryMatcher);
    }

    /**
     * 返回 XML 序列化器, 提供更高级的功能
     *
     * @return XML 序列化器
     */
    public Serializer getSerializer() {
        return serializer;
    }

    /**
     * 序列化一个对象为 XML
     *
     * @param source 要序列化的对象
     * @return XML 字符串
     * @throws XmlParseException XML 解析失败时抛出 XmlParseException
     */
    public String serialize(Object source) throws XmlParseException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            serializer.write(source, out);
            return out.toString("UTF-8");
        } catch (Exception e) {
            throw new XmlParseException(e.getMessage(), e);
        }
    }

    /**
     * 反序列化, 将 XML 还原为对象
     *
     * @param source XML内容
     * @param type   对象类型
     * @param <T>    对象类型
     * @return 对象
     * @throws XmlParseException XML 解析失败时抛出 XmlParseException
     */
    public <T> T deserialize(String source, Class<? extends T> type) throws XmlParseException {
        try {
            return getSerializer().read(type, source);
        } catch (Exception e) {
            throw new XmlParseException(e.getMessage(), e);
        }
    }

}
