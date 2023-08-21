package com.rule1.assist_control_app.dto_entity_mappers;

import com.rule1.assist_control_app.dto.ContractDTO;
import com.rule1.assist_control_app.entity.ContractEntity;
import org.springframework.stereotype.Service;

@Service
public class BuildContractEntity {

    public ContractEntity buildContract(ContractDTO contractDTO){
        return new ContractEntity(
                contractDTO.contractType()
        );
    }
}
