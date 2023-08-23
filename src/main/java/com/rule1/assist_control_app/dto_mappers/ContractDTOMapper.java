package com.rule1.assist_control_app.dto_mappers;

import com.rule1.assist_control_app.dto.ContractDTO;
import com.rule1.assist_control_app.entity.ContractEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ContractDTOMapper implements Function<ContractEntity, ContractDTO> {

    @Override
    public ContractDTO apply(ContractEntity contractEntity) {
        return new ContractDTO(contractEntity.getContractType());
    }
}
