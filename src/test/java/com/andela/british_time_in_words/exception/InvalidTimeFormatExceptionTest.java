package com.andela.british_time_in_words.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidTimeFormatExceptionTest {

    @Test
    void testExceptionMessage() {
        String message = "Invalid time format. Please use HH:mm (e.g., 07:35)";

        InvalidTimeFormatException exception = assertThrows(
                InvalidTimeFormatException.class,
                () -> { throw new InvalidTimeFormatException(message); }
        );

        assertEquals(message, exception.getMessage());
    }
}