package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComputerDTO extends ModelDTO{

    private String category;
    private String processor;
}
