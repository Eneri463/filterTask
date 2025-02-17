package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SmartphoneDTO extends ModelDTO{

    private Integer numberOfCameras;
    private Integer memorySize;
}
