package com.example.testTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComputerRequestDTO extends ModelRequestDTO{
    @NotNull
    @Schema(description = "NotNull")
    private String category;
    @NotNull
    @Schema(description = "NotNull")
    private String processor;
}
