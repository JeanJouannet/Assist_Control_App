package com.rule1.assist_control_app.service;

import com.rule1.assist_control_app.dto.BuildEntityEmployee;
import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.dto.EmployeeDTOMapper;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import com.rule1.assist_control_app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
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
}
