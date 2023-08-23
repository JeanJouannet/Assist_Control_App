package com.rule1.assist_control_app.controller;

import com.rule1.assist_control_app.dto.ContractDTO;
import com.rule1.assist_control_app.entity.ContractEntity;
import com.rule1.assist_control_app.service.impl.ContractServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Assist_Control/")
public class ContractController {

    private final ContractServiceImpl contractServiceImpl;

    public ContractController(ContractServiceImpl contractServiceImpl) {
        this.contractServiceImpl = contractServiceImpl;
    }

    @CrossOrigin
    @PostMapping("/saveNewContract")
    public ResponseEntity<ContractEntity> saveNewContract(@RequestBody ContractDTO contractDTO) {

        return ResponseEntity.ok(contractServiceImpl.saveNewContract(contractDTO));
    }

    @CrossOrigin
    @GetMapping("/contracts")
    public ResponseEntity<List<ContractDTO>> contracts() {
        return ResponseEntity.ok(contractServiceImpl.getAllContracts());
    }
    @CrossOrigin
    @GetMapping("/getUniqueContracts")
    public ResponseEntity<List<String>> uniqueContracts() {
        return ResponseEntity.ok(contractServiceImpl.getUniqueContractTypes());
    }

    @CrossOrigin
    @DeleteMapping("/deleteContractByName/{name}")
    public ResponseEntity<String> deleteContractByName(@PathVariable("name") String name) {
        contractServiceImpl.deleteContractByName(name);
        return ResponseEntity.ok("Contratos eliminados con contractType: " + name);
    }
}
