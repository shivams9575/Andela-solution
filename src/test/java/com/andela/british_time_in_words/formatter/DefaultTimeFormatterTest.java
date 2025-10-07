package com.andela.british_time_in_words.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultTimeFormatterTest {

    private DefaultTimeFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new DefaultTimeFormatter();
    }

    @Test
    void testFormat_MorningTime() {
        LocalTime time = LocalTime.of(7, 35);
        assertEquals("07:35", formatter.format(time));
    }

    @Test
    void testFormat_NoonTime() {
        LocalTime time = LocalTime.of(12, 0);
        assertEquals("12:00", formatter.format(time));
    }

    @Test
    void testFormat_EveningTime() {
        LocalTime time = LocalTime.of(20, 15);
        assertEquals("20:15", formatter.format(time));
    }

    @Test
    void testFormat_Midnight() {
        LocalTime time = LocalTime.of(0, 0);
        assertEquals("00:00", formatter.format(time));
    }

    @Test
    void testFormat_WithSingleDigitHourAndMinute() {
        LocalTime time = LocalTime.of(3, 5);
        assertEquals("03:05", formatter.format(time));
    }
}
