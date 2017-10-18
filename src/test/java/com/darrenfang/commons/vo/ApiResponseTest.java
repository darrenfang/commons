package com.darrenfang.commons.vo;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ApiResponseTest {
    @Test
    public void test() {
        long now = new Date().getTime();
        ApiResponse model = new ApiResponse(1L);
        assertEquals(200, model.getStatus());
        assertEquals("", model.getMessage());
        assertEquals(1L, model.getResult());
        assertTrue(now <= model.getTimestamp());

        now = new Date().getTime();
        model = new ApiResponse(404, "Page Not Found", 1L);
        assertEquals(404, model.getStatus());
        assertEquals("Page Not Found", model.getMessage());
        assertEquals(1L, model.getResult());
        assertTrue(now <= model.getTimestamp());
    }
}
