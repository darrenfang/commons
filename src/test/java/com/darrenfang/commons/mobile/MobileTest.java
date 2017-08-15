package com.darrenfang.commons.mobile;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class MobileTest {
    @Test
    public void testIsMobile() {
        assertFalse(Mobile.isMobile("00000000000"));

        assertTrue(Mobile.isMobile("13000000000"));
        assertTrue(Mobile.isMobile("13100000000"));
        assertTrue(Mobile.isMobile("13200000000"));
        assertTrue(Mobile.isMobile("13300000000"));
        assertTrue(Mobile.isMobile("13400000000"));
        assertTrue(Mobile.isMobile("13500000000"));
        assertTrue(Mobile.isMobile("13600000000"));
        assertTrue(Mobile.isMobile("13700000000"));
        assertTrue(Mobile.isMobile("13800000000"));
        assertTrue(Mobile.isMobile("13900000000"));

        assertTrue(Mobile.isMobile("14500000000"));
        assertTrue(Mobile.isMobile("14700000000"));
        assertTrue(Mobile.isMobile("14900000000"));

        assertTrue(Mobile.isMobile("15000000000"));
        assertTrue(Mobile.isMobile("15100000000"));
        assertTrue(Mobile.isMobile("15200000000"));
        assertTrue(Mobile.isMobile("15300000000"));
        assertTrue(Mobile.isMobile("15500000000"));
        assertTrue(Mobile.isMobile("15600000000"));
        assertTrue(Mobile.isMobile("15700000000"));
        assertTrue(Mobile.isMobile("15800000000"));
        assertTrue(Mobile.isMobile("15900000000"));

        assertTrue(Mobile.isMobile("17000000000"));
        assertTrue(Mobile.isMobile("17100000000"));
        assertTrue(Mobile.isMobile("17300000000"));
        assertTrue(Mobile.isMobile("17500000000"));
        assertTrue(Mobile.isMobile("17600000000"));
        assertTrue(Mobile.isMobile("17700000000"));
        assertTrue(Mobile.isMobile("17800000000"));

        assertTrue(Mobile.isMobile("18000000000"));
        assertTrue(Mobile.isMobile("18100000000"));
        assertTrue(Mobile.isMobile("18200000000"));
        assertTrue(Mobile.isMobile("18300000000"));
        assertTrue(Mobile.isMobile("18400000000"));
        assertTrue(Mobile.isMobile("18500000000"));
        assertTrue(Mobile.isMobile("18600000000"));
        assertTrue(Mobile.isMobile("18700000000"));
        assertTrue(Mobile.isMobile("18800000000"));
        assertTrue(Mobile.isMobile("18900000000"));

        assertFalse(Mobile.isMobile("189000000000"));
    }

    @Test
    public void testTypeOf() {

        assertEquals(MobileType.UNKNOWN, Mobile.typeOf("00000000000"));

        assertEquals(MobileType.UNICOM, Mobile.typeOf("13000000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("13100000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("13200000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("13300000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13400000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13410000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13420000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13430000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13440000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13450000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13460000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13470000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13480000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("13490000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13500000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13600000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13700000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13800000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("13900000000"));

        assertEquals(MobileType.UNICOM, Mobile.typeOf("14500000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("14700000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("14900000000"));

        assertEquals(MobileType.CMCC, Mobile.typeOf("15000000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("15100000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("15200000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("15300000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("15500000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("15600000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("15700000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("15800000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("15900000000"));

        assertEquals(MobileType.TELECOM, Mobile.typeOf("17000000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("17010000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("17020000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("17030000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("17040000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("17050000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("17060000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("17070000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("17080000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("17090000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("17100000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("17300000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("17500000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("17600000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("17700000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("17800000000"));

        assertEquals(MobileType.TELECOM, Mobile.typeOf("18000000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("18100000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("18200000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("18300000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("18400000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("18500000000"));
        assertEquals(MobileType.UNICOM, Mobile.typeOf("18600000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("18700000000"));
        assertEquals(MobileType.CMCC, Mobile.typeOf("18800000000"));
        assertEquals(MobileType.TELECOM, Mobile.typeOf("18900000000"));

        assertEquals(MobileType.UNKNOWN, Mobile.typeOf("189000000000"));
    }

    @Test
    public void testParse() {
        Set<String> mobiles = Mobile.parse(null);

        assertNotNull(mobiles);
        assertEquals(0, mobiles.size());

        mobiles = Mobile.parse("");

        assertNotNull(mobiles);
        assertEquals(0, mobiles.size());

        mobiles = Mobile.parse("5647561866666666613333333333647564834378");

        assertNotNull(mobiles);
        assertEquals(2, mobiles.size());
        assertTrue(mobiles.contains("18666666666"));
        assertTrue(mobiles.contains("13333333333"));
    }
}
