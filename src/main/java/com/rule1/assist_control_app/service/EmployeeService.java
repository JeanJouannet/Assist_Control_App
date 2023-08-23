package com.rule1.assist_control_app.service;

import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeEntity saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getEmployeeByContract(String contractType);

    List<EmployeeDTO> getEmployeeByPosition(String positionType);
}
