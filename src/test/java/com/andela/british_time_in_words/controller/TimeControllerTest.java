package com.andela.british_time_in_words.controller;

import com.andela.british_time_in_words.service.TimeConversionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TimeControllerTest {

        @Mock
        private TimeConversionService timeConversionService;

        @InjectMocks
        private TimeController timeController;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testGetSpokenTime_Success() throws Exception {
            String time = "12:30";
            String locale = "british";
            String spokenTime = "half past twelve";

            when(timeConversionService.convert(time, locale)).thenReturn(spokenTime);

            ResponseEntity<String> response = timeController.getSpokenTime(time, locale);

            assertEquals(200, response.getStatusCodeValue());
            assertEquals(spokenTime, response.getBody());

            verify(timeConversionService, times(1)).convert(time, locale);
        }

    @Test
    void testGetSpokenTime_DefaultLocale() throws Exception {
        String time = "09:15";
        String locale = "british"; // explicitly set
        String spokenTime = "quarter past nine";

        when(timeConversionService.convert(time, locale)).thenReturn(spokenTime);

        // Pass "british" instead of null
        ResponseEntity<String> response = timeController.getSpokenTime(time, locale);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(spokenTime, response.getBody());

        verify(timeConversionService, times(1)).convert(time, locale);
    }


    @Test
        void testGetSpokenTime_Exception() throws Exception {
            String time = "invalid";
            String locale = "british";

            when(timeConversionService.convert(time, locale))
                    .thenThrow(new IllegalArgumentException("Invalid time format"));

            ResponseEntity<String> response = timeController.getSpokenTime(time, locale);

            assertEquals(500, response.getStatusCodeValue());
            assertEquals("Error: Invalid time format", response.getBody());

            verify(timeConversionService, times(1)).convert(time, locale);
        }
}
