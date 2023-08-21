package com.rule1.assist_control_app.dto_entity_mappers;

import com.rule1.assist_control_app.dto.ContractDTO;
import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.entity.ContractEntity;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ContractDTOMapper implements Function<ContractEntity, ContractDTO> {

    @Override
    public ContractDTO apply(ContractEntity contractEntity) {
        return new ContractDTO(contractEntity.getContractType(),
                contractEntity.getSalary());
    }
}
