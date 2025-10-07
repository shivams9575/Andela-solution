package com.andela.british_time_in_words.factory;

import com.andela.british_time_in_words.formatter.TimeFormatterStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class TimeFormatterFactoryTest {
    private TimeFormatterFactory factory;

    @Component("british")
    static class BritishStrategy implements TimeFormatterStrategy {
        @Override
        public String format(LocalTime time) {
            return "british-time"; // dummy value
        }
    }

    @Component("american")
    static class AmericanStrategy implements TimeFormatterStrategy {
        @Override
        public String format(LocalTime time) {
            return "american-time"; // dummy value
        }
    }

    @BeforeEach
    void setUp() {
        BritishStrategy britishStrategy = new BritishStrategy();
        AmericanStrategy americanStrategy = new AmericanStrategy();

        // Pass real objects so @Component annotation exists
        factory = new TimeFormatterFactory(List.of(britishStrategy, americanStrategy));
    }

    @Test
    void testGetFormatter_ExistingLocale() {
        assertEquals(BritishStrategy.class, factory.getFormatter("british").getClass());
        assertEquals(AmericanStrategy.class, factory.getFormatter("american").getClass());
    }

    @Test
    void testGetFormatter_NullLocale_FallbackToBritish() {
        assertEquals(BritishStrategy.class, factory.getFormatter(null).getClass());
    }

    @Test
    void testGetFormatter_UnsupportedLocale_FallbackToBritish() {
        assertEquals(BritishStrategy.class, factory.getFormatter("french").getClass());
    }
}
