package com.andela.british_time_in_words.service;

import com.andela.british_time_in_words.exception.InvalidTimeFormatException;
import com.andela.british_time_in_words.factory.TimeFormatterFactory;
import com.andela.british_time_in_words.formatter.TimeFormatterStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TimeConversionService {

    private final TimeFormatterFactory factory;

    public TimeConversionService(TimeFormatterFactory factory) {
        this.factory = factory;
    }

    /**
     * Converts input time string into spoken form for a given locale.
     *
     * @param timeString input time in HH:mm format
     * @param locale     locale identifier (e.g., "british")
     * @return spoken representation of time
     */
    public String convert(String timeString, String locale) {
        try {
            LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
            TimeFormatterStrategy formatter = factory.getFormatter(locale);
            return formatter.format(time);
        } catch (DateTimeParseException ex) {
            throw new InvalidTimeFormatException("Invalid time format. Please use HH:mm (e.g., 07:35)");
        }
    }
}
