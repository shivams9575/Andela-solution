package com.andela.british_time_in_words;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BritishTimeInWordsApplicationTest {

    @Test
    void testRunLogsMessages() {
        // Capture logs from BritishTimeInWordsApplication class
        LogCaptor logCaptor = LogCaptor.forClass(BritishTimeInWordsApplication.class);

        BritishTimeInWordsApplication app = new BritishTimeInWordsApplication();
        app.run();

        // Verify the logs
        assertTrue(logCaptor.getInfoLogs().contains("British Spoken Time Application Started Successfully!"));
        assertTrue(logCaptor.getInfoLogs().contains("Ready to convert digital time → spoken British English"));
    }
}
