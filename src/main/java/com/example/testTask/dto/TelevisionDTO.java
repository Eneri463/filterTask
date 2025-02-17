package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TelevisionDTO extends ModelDTO{

    private String category;
    private String technology;
}
