package com.andela.british_time_in_words.formatter;

import org.springframework.stereotype.Component;
import java.time.LocalTime;
@Component("default")
public class DefaultTimeFormatter implements TimeFormatterStrategy {

    @Override
    public String format(LocalTime time) {
        return time.toString(); // e.g., "07:35"
    }
}
