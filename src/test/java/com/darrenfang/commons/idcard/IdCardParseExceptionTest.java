package com.darrenfang.commons.idcard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IdCardParseExceptionTest {

    @Test
    public void test() {
        IdCardParseException exception = new IdCardParseException("Business Exception message");
        assertEquals("Business Exception message", exception.getMessage());
    }

}
