package com.darrenfang.commons.json;

import com.darrenfang.commons.web.ViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonUtilTest {

    @Test
    public void testToJsonString() {
        String json = JsonUtil.toJsonString(new ViewModel());
        assertEquals("{\"code\":200,\"message\":\"\"}", json);

        json = JsonUtil.toJsonString(new ViewModel(404, "Page Not Found"));
        assertEquals("{\"code\":404,\"message\":\"Page Not Found\"}", json);
    }

    @Test
    public void testToObject() {
        String json = "{\"code\":200,\"message\":\"\"}";
        ViewModel model = JsonUtil.toObject(json, ViewModel.class);
        assertEquals(200, model.getCode());
        assertEquals("", model.getMessage());

        json = "{\"code\":404,\"message\":\"Page Not Found\"}";
        model = JsonUtil.toObject(json, ViewModel.class);
        assertEquals(404, model.getCode());
        assertEquals("Page Not Found", model.getMessage());
    }

}
