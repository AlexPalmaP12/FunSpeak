package com.example.funspeak.tasksmodels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SelectPhotoTaskModel {
    private String correctOptionName;
    private int option1ImageId;
    private int option2ImageId;
    private int option3ImageId;
    private int option4ImageId;
    private int correctImageId;
}
