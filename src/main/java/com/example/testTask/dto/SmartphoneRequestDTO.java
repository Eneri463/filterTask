package com.example.testTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SmartphoneRequestDTO extends ModelRequestDTO{
    @NotNull
    @Schema(description = "NotNull")
    private Integer numberOfCameras;
    @NotNull
    @Schema(description = "NotNull")
    private Integer memorySize;
}
