package com.andela.british_time_in_words.service;

import com.andela.british_time_in_words.exception.InvalidTimeFormatException;
import com.andela.british_time_in_words.factory.TimeFormatterFactory;
import com.andela.british_time_in_words.formatter.TimeFormatterStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TimeConversionServiceTest {

    @Mock
    private TimeFormatterFactory factory;

    @Mock
    private TimeFormatterStrategy formatterStrategy;

    @InjectMocks
    private TimeConversionService timeConversionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConvert_ValidTime() {
        String timeString = "12:30";
        String locale = "british";
        String expected = "half past twelve";

        when(factory.getFormatter(locale)).thenReturn(formatterStrategy);
        when(formatterStrategy.format(LocalTime.parse(timeString))).thenReturn(expected);

        String result = timeConversionService.convert(timeString, locale);

        assertEquals(expected, result);
        verify(factory, times(1)).getFormatter(locale);
        verify(formatterStrategy, times(1)).format(LocalTime.parse(timeString));
    }

    @Test
    void testConvert_InvalidTimeFormat() {
        String invalidTime = "25:00";
        String locale = "british";

        InvalidTimeFormatException exception = assertThrows(
                InvalidTimeFormatException.class,
                () -> timeConversionService.convert(invalidTime, locale)
        );

        assertEquals("Invalid time format. Please use HH:mm (e.g., 07:35)", exception.getMessage());
        verify(factory, never()).getFormatter(anyString());
    }

    @Test
    void testConvert_NullTime() {
        String nullTime = null;
        String locale = "british";

        assertThrows(NullPointerException.class, () -> timeConversionService.convert(nullTime, locale));
        verify(factory, never()).getFormatter(anyString());
    }
}
