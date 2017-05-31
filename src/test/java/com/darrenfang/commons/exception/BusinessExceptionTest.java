package com.darrenfang.commons.exception;

import org.junit.Test;

import static org.junit.Assert.*;

public class BusinessExceptionTest {

    @Test
    public void test() {
        BusinessException exception = new BusinessException("Business Exception message");
        assertEquals("Business Exception message", exception.getMessage());
    }

}
