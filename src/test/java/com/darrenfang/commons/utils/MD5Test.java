package com.darrenfang.commons.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5Test {
    @Test
    public void testToLowerCase() {
        String md5 = MD5.toLowerCase("Hello World");
        assertEquals("b10a8db164e0754105b7a99be72e3fe5", md5);
    }

    @Test
    public void testToUpperCase() {
        String md5 = MD5.toUpperCase("Hello World");
        assertEquals("B10A8DB164E0754105B7A99BE72E3FE5", md5);
    }
}
