package com.andela.british_time_in_words;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BritishTimeInWordsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BritishTimeInWordsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("British Spoken Time Application Started Successfully!");
        log.info("Ready to convert digital time → spoken British English");
    }

}
