package com.rule1.assist_control_app.service.impl;

import com.rule1.assist_control_app.builder.BuildEmployeeEntity;
import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.dto_mappers.EmployeeDTOMapper;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import com.rule1.assist_control_app.repository.EmployeeRepository;
import com.rule1.assist_control_app.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeDTOMapper employeeDTOMapper;

    private final BuildEmployeeEntity buildEmployeeEntity;
    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeDTOMapper employeeDTOMapper, BuildEmployeeEntity buildEmployeeEntity) {
        this.repository = repository;
        this.employeeDTOMapper = employeeDTOMapper;
        this.buildEmployeeEntity = buildEmployeeEntity;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(employeeDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeDTO employeeDTO) {
        return repository.save(buildEmployeeEntity.buildEmployee(employeeDTO));
    }

    @Override
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

    @Override
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
