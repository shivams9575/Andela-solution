package com.andela.british_time_in_words.factory;

import com.andela.british_time_in_words.formatter.TimeFormatterStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
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
        log.info("Loaded formatters: {}" , formatters.keySet());
    }

    public TimeFormatterStrategy getFormatter(String locale) {
        if (locale == null || !formatters.containsKey(locale.toLowerCase())) {
            locale = "british";
        }
        return formatters.get(locale.toLowerCase());
    }
}
