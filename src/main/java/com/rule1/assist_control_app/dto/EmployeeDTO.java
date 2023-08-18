package com.rule1.assist_control_app.dto;

import com.rule1.assist_control_app.entity.ContractEntity;
import com.rule1.assist_control_app.entity.PositionEntity;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record EmployeeDTO(
        @NotEmpty @NotNull String rut,
        @Min(0) @Max(99_999_999) Integer salary,
        @NotEmpty @NotNull String name,
        @NotEmpty @NotNull String surname,
        String secondSurname,
        @Email @NotNull String email,
        @Size(max = 15) String phoneNumber,
        LocalDate birthday,
        @NotNull @Min(18) Integer age,
        @NotEmpty @NotNull String nationality,
        @NotNull PositionEntity position,
        @NotNull ContractEntity contract


) {
}
