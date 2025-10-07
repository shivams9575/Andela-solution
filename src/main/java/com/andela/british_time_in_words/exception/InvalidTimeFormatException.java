package com.andela.british_time_in_words.exception;

public class InvalidTimeFormatException extends RuntimeException{
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
