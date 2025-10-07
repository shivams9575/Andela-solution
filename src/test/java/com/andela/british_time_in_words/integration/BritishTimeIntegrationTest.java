package com.andela.british_time_in_words.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BritishTimeIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testBritishTimeFormatter_07_35() throws Exception {
        mockMvc.perform(get("/BSTApi/britishSpokenTime/07:35?locale=british"))
                .andExpect(status().isOk())
                .andExpect(content().string("twenty five to eight"));
    }

    @Test
    void testBritishTimeFormatter_04_15() throws Exception {
        mockMvc.perform(get("/BSTApi/britishSpokenTime/04:15?locale=british"))
                .andExpect(status().isOk())
                .andExpect(content().string("quarter past four"));
    }

    @Test
    void testBritishTimeFormatter_Noon() throws Exception {
        mockMvc.perform(get("/BSTApi/britishSpokenTime/12:00?locale=british"))
                .andExpect(status().isOk())
                .andExpect(content().string("noon"));
    }

    @Test
    void testBritishTimeFormatter_Midnight() throws Exception {
        mockMvc.perform(get("/BSTApi/britishSpokenTime/00:00?locale=british"))
                .andExpect(status().isOk())
                .andExpect(content().string("midnight"));
    }

    @Test
    void testInvalidTimeFormat() throws Exception {
        mockMvc.perform(get("/BSTApi/britishSpokenTime/99:99"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Invalid time format")));
    }
}
