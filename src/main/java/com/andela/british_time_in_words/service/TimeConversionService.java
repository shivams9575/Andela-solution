package com.andela.british_time_in_words.service;

import com.andela.british_time_in_words.exception.InvalidTimeFormatException;
import com.andela.british_time_in_words.factory.TimeFormatterFactory;
import com.andela.british_time_in_words.formatter.TimeFormatterStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TimeConversionService {

    @Autowired
    private TimeFormatterFactory factory;

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
