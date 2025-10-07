package com.andela.british_time_in_words.factory;

import com.andela.british_time_in_words.formatter.TimeFormatterStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TimeFormatterFactory {
    private final Map<String, TimeFormatterStrategy> formatters;

    @Autowired
    public TimeFormatterFactory(List<TimeFormatterStrategy> strategies) {
        this.formatters = strategies.stream()
                .collect(Collectors.toMap(
                        s -> s.getClass().getAnnotation(org.springframework.stereotype.Component.class).value(),
                        s -> s
                ));
        System.out.println("Loaded formatters: " + formatters.keySet());
    }

    public TimeFormatterStrategy getFormatter(String locale) {
        if (locale == null || !formatters.containsKey(locale.toLowerCase()))
            locale = "british";
        return formatters.get(locale.toLowerCase());
    }
}
