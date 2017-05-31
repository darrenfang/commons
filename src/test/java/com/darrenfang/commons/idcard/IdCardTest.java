package com.darrenfang.commons.idcard;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.*;

public class IdCardTest {
    @Test(expected = IdCardParseException.class)
    public void testParseNull() {
        IdCard.parse(null);
    }

    @Test(expected = IdCardParseException.class)
    public void testParseEmpty() {
        IdCard.parse("");
    }

    @Test(expected = IdCardParseException.class)
    public void testParseLengthError() {
        IdCard.parse("1234567890");
    }

    @Test(expected = IdCardParseException.class)
    public void testParseInvalid() {
        IdCard.parse("450126198104206936");
    }

    @Test
    public void testParse() {
        IdCard idCard = IdCard.parse("450126198104206935");
        assertNotNull(idCard);
        assertEquals("450126198104206935", idCard.getCard());
        assertEquals(Date.from(LocalDate.of(1981, 4, 20).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), idCard.getBirthday());
        assertTrue(idCard.isMale());

        idCard = IdCard.parse("450125197802207280");
        assertNotNull(idCard);
        assertEquals("450125197802207280", idCard.getCard());
        assertEquals(Date.from(LocalDate.of(1978, 2, 20).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), idCard.getBirthday());
        assertFalse(idCard.isMale());

        idCard = IdCard.parse("310112850409522");
        assertNotNull(idCard);
        assertEquals("310112198504095227", idCard.getCard());
        assertEquals(Date.from(LocalDate.of(1985, 4, 9).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), idCard.getBirthday());
        assertFalse(idCard.isMale());
    }
}
