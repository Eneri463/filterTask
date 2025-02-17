package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VacuumCleanerDTO extends ModelDTO{

    private Double volume;
    private Integer numberOfModes;
}
