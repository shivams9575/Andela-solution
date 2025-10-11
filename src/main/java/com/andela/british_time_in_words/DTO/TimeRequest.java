package com.andela.british_time_in_words.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TimeRequest {

    private String time;
    private String locale = "british";

}
