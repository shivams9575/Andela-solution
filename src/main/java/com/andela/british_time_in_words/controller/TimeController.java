package com.andela.british_time_in_words.controller;

import com.andela.british_time_in_words.DTO.TimeRequest;
import com.andela.british_time_in_words.service.TimeConversionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class TimeController {

    @Autowired
    private TimeConversionService timeConversionService;


    @PostMapping("/britishSpokenTime")
    public ResponseEntity<String> getSpokenTime(@RequestBody TimeRequest request) {

        log.info("Received request: time='{}', locale='{}'", request.getTime(), request.getLocale());

        try {
            String spokenTime = timeConversionService.convert(request.getTime(), request.getLocale());
            log.info("Successfully converted [{}] to spoken form: [{}]", request.getTime(), spokenTime);
            return ResponseEntity.ok(spokenTime);
        } catch(Exception e){
            log.error(
                    "Error while processing time='{}', locale='{}' → {}",
                    request.getTime(), request.getLocale(), e.getMessage()
            );
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
