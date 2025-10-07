package com.andela.british_time_in_words.controller;

import com.andela.british_time_in_words.service.TimeConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    private final TimeConversionService timeConversionService;

    public TimeController(TimeConversionService timeConversionService) {
        this.timeConversionService = timeConversionService;
    }

    /**
     * Example: GET /api/time/07:35?locale=british
     *
     * @param time   input time in HH:mm format
     * @param locale locale string (default = british)
     * @return spoken time representation
     */
    @GetMapping("/{time}")
    public ResponseEntity<String> getSpokenTime(
            @PathVariable String time,
            @RequestParam(defaultValue = "british") String locale) {

        String result = timeConversionService.convert(time, locale);
        return ResponseEntity.ok(result);
    }
}
