package com.rule1.assist_control_app.service;

import com.rule1.assist_control_app.dto.ContractDTO;
import com.rule1.assist_control_app.entity.ContractEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public interface ContractService {

    ContractEntity saveNewContract(ContractDTO contractDTO);

    List<ContractDTO> getAllContracts();

    List<String> getUniqueContractTypes();

    void deleteContractByName(String s);
}
