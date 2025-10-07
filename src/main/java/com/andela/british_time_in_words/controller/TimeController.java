package com.andela.british_time_in_words.controller;

import com.andela.british_time_in_words.service.TimeConversionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/BSTApi")
public class TimeController {

    @Autowired
    private TimeConversionService timeConversionService;


    @GetMapping("britishSpokenTime/{time}")
    public ResponseEntity<String> getSpokenTime(
            @PathVariable String time,
            @RequestParam(defaultValue = "british") String locale) {

        log.info("Received request: time='{}', locale='{}'", time, locale);

        try {
            String spokenTime = timeConversionService.convert(time, locale);
            log.info("✅ Successfully converted [{}] to spoken form: [{}]", time, spokenTime);
            return ResponseEntity.ok(spokenTime);
        } catch(Exception e){
            log.error("Error while processing time='{}', locale='{}' → {}", time, locale, e.getMessage());
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
