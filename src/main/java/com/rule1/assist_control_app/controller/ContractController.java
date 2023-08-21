package com.rule1.assist_control_app.controller;

import com.rule1.assist_control_app.dto.ContractDTO;
import com.rule1.assist_control_app.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assist_Control/")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @CrossOrigin
    @GetMapping("/contracts")
    public ResponseEntity<List<ContractDTO>> contracts() {
        return ResponseEntity.ok(contractService.getAllContracts());
    }
    @CrossOrigin
    @GetMapping("/getUniqueContracts")
    public ResponseEntity<List<String>> uniqueContracts() {
        return ResponseEntity.ok(contractService.getUniqueContractTypes());
    }
}
