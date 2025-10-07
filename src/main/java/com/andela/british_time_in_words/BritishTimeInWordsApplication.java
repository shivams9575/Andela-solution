package com.andela.british_time_in_words;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BritishTimeInWordsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BritishTimeInWordsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n--------------------------------------------");
        System.out.println("🚀 British Spoken Time Application is starting up...");
        System.out.println("✅ Ready to convert time into spoken British English!");
        System.out.println("💡 Try: http://localhost:8080/api/time/07:35");
        System.out.println("--------------------------------------------\n");
    }

}
