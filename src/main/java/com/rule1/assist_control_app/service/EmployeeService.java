package com.rule1.assist_control_app.service;

import com.rule1.assist_control_app.dto_entity_mappers.BuildEntityEmployee;
import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.dto_entity_mappers.EmployeeDTOMapper;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import com.rule1.assist_control_app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeDTOMapper employeeDTOMapper;

    private final BuildEntityEmployee buildEntityEmployee;
    public EmployeeService(EmployeeRepository repository, EmployeeDTOMapper employeeDTOMapper, BuildEntityEmployee buildEntityEmployee) {
        this.repository = repository;
        this.employeeDTOMapper = employeeDTOMapper;
        this.buildEntityEmployee = buildEntityEmployee;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(employeeDTOMapper)
                .collect(Collectors.toList());
    }

    public EmployeeEntity saveEmployee(EmployeeDTO employeeDTO) {
        return repository.save(buildEntityEmployee.buildEmployee(employeeDTO));
    }

    public List<EmployeeDTO> getEmployeeByContract(String contractType) {
        List<EmployeeDTO> allEmployees;
        List<EmployeeDTO> empContract = new ArrayList<>();

        allEmployees = repository.findAll()
                .stream()
                .map(employeeDTOMapper)
                .collect(Collectors.toList());

        for (EmployeeDTO e: allEmployees) {
            if(Objects.equals(e.contract().getContractType(), contractType)) {
                empContract.add(e);
            }
        }
        return empContract;
    }

    public List<EmployeeDTO> getEmployeeByPosition(String positionType) {
        List<EmployeeDTO> allEmployees;
        List<EmployeeDTO> empPosition = new ArrayList<>();

        allEmployees = repository.findAll()
                .stream()
                .map(employeeDTOMapper)
                .collect(Collectors.toList());

        for (EmployeeDTO e: allEmployees) {
            if(Objects.equals(e.position().getPositionType(), positionType)) {
                empPosition.add(e);
            }
        }
        return empPosition;
    }
}
