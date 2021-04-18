package com.example.funspeak.tasksmodels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompletePhraseTaskModel {
    private String phrase;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctOption;
}

