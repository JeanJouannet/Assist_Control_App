package com.rule1.assist_control_app.controller;

import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import com.rule1.assist_control_app.service.impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Assist_Control/")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @CrossOrigin
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> employees() {
        return ResponseEntity.ok(employeeServiceImpl.getAllEmployees());
    }

    @CrossOrigin
    @GetMapping("/getEmployeesByContract/{contract}")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesByContract(@PathVariable("contract") String contract) {
        return ResponseEntity.ok(employeeServiceImpl.getEmployeeByContract(contract));
    }

    @CrossOrigin
    @GetMapping("/getEmployeesByPosition/{position}")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesByPosition(@PathVariable("position") String position) {
        return ResponseEntity.ok(employeeServiceImpl.getEmployeeByPosition(position));
    }

    @CrossOrigin
    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeServiceImpl.saveEmployee(employeeDTO));
    }



}
