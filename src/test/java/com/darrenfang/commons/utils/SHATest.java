package com.darrenfang.commons.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class SHATest {
    @Test
    public void testToSHA1() {
        String string = SHA.toSHA1("Hello World");
        assertEquals("0a4d55a8d778e5022fab701977c5d840bbc486d0", string);
    }

    @Test
    public void testToSHA224() {
        String string = SHA.toSHA224("Hello World");
        assertEquals("c4890faffdb0105d991a461e668e276685401b02eab1ef4372795047", string);
    }

    @Test
    public void testToSHA256() {
        String string = SHA.toSHA256("Hello World");
        assertEquals("a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e", string);
    }

    @Test
    public void testToSHA384() {
        String string = SHA.toSHA384("Hello World");
        assertEquals("99514329186b2f6ae4a1329e7ee6c610a729636335174ac6b740f9028396fcc803d0e93863a7c3d90f86beee782f4f3f", string);
    }

    @Test
    public void testToSHA512() {
        String string = SHA.toSHA512("Hello World");
        assertEquals("2c74fd17edafd80e8447b0d46741ee243b7eb74dd2149a0ab1b9246fb30382f27e853d8585719e0e67cbda0daa8f51671064615d645ae27acb15bfb1447f459b", string);
    }
}
