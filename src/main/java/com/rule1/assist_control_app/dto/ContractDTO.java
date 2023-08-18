package com.rule1.assist_control_app.dto;

import com.rule1.assist_control_app.entity.ContractType;

public record ContractDTO(
        Long contractId,
        ContractType contractType
) {
}
