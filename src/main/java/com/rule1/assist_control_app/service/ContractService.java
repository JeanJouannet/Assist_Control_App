package com.rule1.assist_control_app.service;

import com.rule1.assist_control_app.dto.ContractDTO;
import com.rule1.assist_control_app.dto_entity_mappers.BuildContractEntity;
import com.rule1.assist_control_app.dto_entity_mappers.ContractDTOMapper;
import com.rule1.assist_control_app.entity.ContractEntity;
import com.rule1.assist_control_app.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ContractDTOMapper contractDTOMapper;
    private final BuildContractEntity buildContractEntity;

    public ContractService(ContractRepository contractRepository, ContractDTOMapper contractDTOMapper, BuildContractEntity buildContractEntity) {
        this.contractRepository = contractRepository;
        this.contractDTOMapper = contractDTOMapper;
        this.buildContractEntity = buildContractEntity;
    }

    public ContractEntity saveNewContract(ContractDTO contractDTO) {
        return contractRepository.save(buildContractEntity.buildContract(contractDTO));
    }

    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll()
                .stream()
                .map(contractDTOMapper)
                .collect(Collectors.toList());
    }

    public List<String> getUniqueContractTypes() {
        List<ContractDTO> allContracts = contractRepository.findAll()
                .stream()
                .map(contractDTOMapper)
                .collect(Collectors.toList());

        Set<String> uniqueContractTypes = new HashSet<>();

        for (ContractDTO c : allContracts) {
            uniqueContractTypes.add(c.contractType());
        }

        return new ArrayList<>(uniqueContractTypes);
    }
}


