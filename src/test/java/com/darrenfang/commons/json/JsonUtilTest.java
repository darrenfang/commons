package com.darrenfang.commons.json;

import com.darrenfang.commons.MockObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonUtilTest {

    @Test
    public void testToJsonString() {
        String json = JsonUtil.toJsonString(new MockObject());
        assertEquals("{\"code\":200,\"message\":\"\"}", json);

        json = JsonUtil.toJsonString(new MockObject(404, "Page Not Found"));
        assertEquals("{\"code\":404,\"message\":\"Page Not Found\"}", json);
    }

    @Test
    public void testToObject() {
        String json = "{\"code\":200,\"message\":\"\"}";
        MockObject model = JsonUtil.toObject(json, MockObject.class);
        assertEquals(200, model.getCode());
        assertEquals("", model.getMessage());

        json = "{\"code\":404,\"message\":\"Page Not Found\"}";
        model = JsonUtil.toObject(json, MockObject.class);
        assertEquals(404, model.getCode());
        assertEquals("Page Not Found", model.getMessage());
    }

}
