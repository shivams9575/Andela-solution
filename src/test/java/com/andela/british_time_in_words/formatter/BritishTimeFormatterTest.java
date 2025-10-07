package com.andela.british_time_in_words.formatter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BritishTimeFormatterTest {
    private BritishTimeFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new BritishTimeFormatter();
    }

    @Test
    void testMidnight() {
        LocalTime time = LocalTime.of(0, 0);
        assertEquals("midnight", formatter.format(time));
    }

    @Test
    void testNoon() {
        LocalTime time = LocalTime.of(12, 0);
        assertEquals("noon", formatter.format(time));
    }

    @Test
    void testOClock() {
        LocalTime time = LocalTime.of(3, 0);
        assertEquals("three o'clock", formatter.format(time));
    }

    @Test
    void testPastMinutes() {
        LocalTime time1 = LocalTime.of(2, 5);
        assertEquals("five past two", formatter.format(time1));

        LocalTime time2 = LocalTime.of(4, 20);
        assertEquals("twenty past four", formatter.format(time2));
    }

    @Test
    void testQuarterPast() {
        LocalTime time = LocalTime.of(9, 15);
        assertEquals("quarter past nine", formatter.format(time));
    }

    @Test
    void testHalfPast() {
        LocalTime time = LocalTime.of(6, 30);
        assertEquals("half past six", formatter.format(time));
    }

    @Test
    void testToMinutes() {
        LocalTime time = LocalTime.of(5, 40);
        assertEquals("twenty to six", formatter.format(time));

        LocalTime time2 = LocalTime.of(11, 50);
        assertEquals("ten to twelve", formatter.format(time2));
    }

    @Test
    void testQuarterTo() {
        LocalTime time = LocalTime.of(8, 45);
        assertEquals("quarter to nine", formatter.format(time));
    }

    @Test
    void testEdgeCases() {
        LocalTime time = LocalTime.of(23, 59);
        assertEquals("one to twelve", formatter.format(time));
    }
}
