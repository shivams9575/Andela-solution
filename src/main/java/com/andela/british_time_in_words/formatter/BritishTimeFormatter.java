package com.andela.british_time_in_words.formatter;

import org.springframework.stereotype.Component;
import java.time.LocalTime;
@Component("british")
public class BritishTimeFormatter implements TimeFormatterStrategy  {

    private static final String[] HOURS = {
            "twelve", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven"
    };

    private static final String[] MINUTES = {
            "o'clock", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "quarter", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
            "twenty three", "twenty four", "twenty five", "twenty six",
            "twenty seven", "twenty eight", "twenty nine", "half"
    };
    @Override
    public String format(LocalTime time) {
        // Logic for British spoken time
        int hour = time.getHour();
        int minute = time.getMinute();

        if (hour == 0 && minute == 0) {
            return "midnight";
        } else if (hour == 12 && minute == 0) {
            return "noon";
        }

        if (minute == 0) {
            return HOURS[hour % 12] + " o'clock";
        } else if (minute <= 30) {
            if (minute == 15) return "quarter past " + HOURS[hour % 12];
            if (minute == 30) return "half past " + HOURS[hour % 12];
            return MINUTES[minute] + " past " + HOURS[hour % 12];
        } else {
            int minutesTo = 60 - minute;
            int nextHour = (hour + 1) % 24;
            if (minutesTo == 15) return "quarter to " + HOURS[nextHour % 12];
            return MINUTES[minutesTo] + " to " + HOURS[nextHour % 12];
        }
    }
}
