package com.darrenfang.commons.json;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json 工具类
 */
public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private JsonUtil() {
    }

    static {
        mapper.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 将对象转换为 Json
     *
     * @param object 待转换的对象
     * @return Json 字符串
     * @throws JsonParseException 解析失败时抛出 JsonParseException
     */
    public static String toJsonString(Object object) throws JsonParseException {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JsonParseException(e.getMessage(), e);
        }
    }

    /**
     * 将 Json 字符串转换为对象
     *
     * @param json  Json 字符串
     * @param clazz 对象类型
     * @param <T>   对象类型
     * @return 解析后的对象
     * @throws JsonParseException 解析失败时抛出 JsonParseException
     */
    public static <T> T toObject(String json, Class<T> clazz) throws JsonParseException {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new JsonParseException(e.getMessage(), e);
        }
    }

    /**
     * 读取 Json 字符串
     *
     * @param json Json 字符串
     * @return JsonNode 对象
     */
    public static JsonNode readTree(String json) {
        try {
            return mapper.readTree(json);
        } catch (IOException e) {
            throw new JsonParseException(e.getMessage(), e);
        }
    }
}
