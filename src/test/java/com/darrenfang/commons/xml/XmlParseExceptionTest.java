package com.darrenfang.commons.xml;

import org.junit.Test;

import static org.junit.Assert.*;

public class XmlParseExceptionTest {

    @Test
    public void test() {
        XmlParseException exception = new XmlParseException("Business Exception message");
        assertEquals("Business Exception message", exception.getMessage());
    }

}
