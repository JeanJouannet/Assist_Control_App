package com.rule1.assist_control_app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PositionDTO(
        @NotNull @NotEmpty String positionType
) {

}
