package com.example.testTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModelRequestDTO {

    @NotNull
    @Schema(description = "NotNull")
    private Long applianceId;
    @NotNull
    @Schema(description = "NotNull")
    private String name;
    @NotNull
    @Schema(description = "NotNull")
    private String serialNumber;
    @NotNull
    @Schema(description = "NotNull")
    private String colour;
    @NotNull
    @Schema(description = "NotNull")
    private String size;
    @NotNull
    @Schema(description = "NotNull")
    private double price;
    @NotNull
    @Schema(description = "NotNull")
    private boolean available;
}
