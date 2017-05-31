package com.darrenfang.commons.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class Base64Test {

    @Test
    public void testToString() {
        String base64String = Base64.toString("Hello World");
        assertEquals("SGVsbG8gV29ybGQ=", base64String);
    }

    @Test
    public void testParseString() {
        String string = Base64.parseString("SGVsbG8gV29ybGQ=");
        assertEquals("Hello World", string);
    }

    @Test
    public void testParseBytes() {
        byte[] bytes = Base64.parseBytes("SGVsbG8gV29ybGQ=");
        assertArrayEquals(new byte[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'}, bytes);
    }
}
