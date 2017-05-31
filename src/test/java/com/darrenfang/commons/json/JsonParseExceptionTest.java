package com.darrenfang.commons.json;

import org.junit.Test;

import static org.junit.Assert.*;

public class JsonParseExceptionTest {
    @Test
    public void test() {
        JsonParseException exception = new JsonParseException("Business Exception message");
        assertEquals("Business Exception message", exception.getMessage());
    }
}
