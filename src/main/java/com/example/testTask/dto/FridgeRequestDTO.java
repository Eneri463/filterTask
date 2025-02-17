package com.example.testTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FridgeRequestDTO extends ModelRequestDTO{
    @NotNull
    @Schema(description = "NotNull")
    private Integer numberOfDoors;
    @NotNull
    @Schema(description = "NotNull")
    private String compressor;
}
