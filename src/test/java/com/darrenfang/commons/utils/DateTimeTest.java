package com.darrenfang.commons.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class DateTimeTest {

    @Test
    public void testDateToLocalDateTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2017-12-01 12:30:00");
        LocalDateTime localDateTime = DateTime.from(date);
        assertEquals(2017, localDateTime.getYear());
        assertEquals(12, localDateTime.getMonthValue());
        assertEquals(1, localDateTime.getDayOfMonth());
        assertEquals(12, localDateTime.getHour());
        assertEquals(30, localDateTime.getMinute());
        assertEquals(0, localDateTime.getSecond());
    }

    @Test
    public void testLocalDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.of(2017, 12, 1, 12, 30, 0);
        Date date = DateTime.from(localDateTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals("2017-12-01 12:30:00", format.format(date));
    }
}
