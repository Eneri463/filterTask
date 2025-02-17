package com.example.testTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Тело запроса для добавления нового вида техники в таблицу 'техника'")
public class ApplianceDTO {

    @Schema(description = "необязательный параметр (может быть проигнорирован)")
    Long applianceId;
    @NotNull
    @Schema(description = "NotNull")
    private String type;
    @NotNull
    @Schema(description = "NotNull")
    private String company;
    @NotNull
    @Schema(description = "NotNull")
    private String country;
    @NotNull
    @Schema(description = "NotNull")
    private Boolean onlineOrder;
    @NotNull
    @Schema(description = "NotNull")
    private Boolean installment;
}
