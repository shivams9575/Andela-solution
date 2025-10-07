package com.andela.british_time_in_words.formatter;

import java.time.LocalTime;

public interface TimeFormatterStrategy {

    String format(LocalTime time);
}
