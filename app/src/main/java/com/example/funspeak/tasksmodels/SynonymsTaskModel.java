package com.example.funspeak.tasksmodels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SynonymsTaskModel {
    private String synonym;
    private String synonym1;
    private String synonym2;
    private String synonym3;
    private String synonym4;
    private String correctSynonym;
}
