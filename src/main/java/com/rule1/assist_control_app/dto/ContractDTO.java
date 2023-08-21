package com.rule1.assist_control_app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ContractDTO(
        @NotNull @NotEmpty String contractType,
        @NotNull @Min(0) @Max(99_999_999) Integer salary
) {
}
