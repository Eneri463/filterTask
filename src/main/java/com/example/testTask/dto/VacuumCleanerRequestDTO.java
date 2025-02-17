package com.example.testTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VacuumCleanerRequestDTO extends ModelRequestDTO{
    @NotNull
    @Schema(description = "NotNull")
    private Double volume;
    @NotNull
    @Schema(description = "NotNull")
    private Integer numberOfModes;
}
