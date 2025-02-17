package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FridgeDTO extends ModelDTO{

    private Integer numberOfDoors;
    private String compressor;
}
