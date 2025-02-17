package com.example.testTask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModelDTO extends ApplianceDTO {

    private Long modelId;
    private String name;
    private String serialNumber;
    private String colour;
    private String size;
    private double price;
    private boolean available;

}
