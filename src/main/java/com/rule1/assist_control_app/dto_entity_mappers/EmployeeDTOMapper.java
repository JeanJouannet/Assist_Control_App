package com.rule1.assist_control_app.dto_entity_mappers;

import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmployeeDTOMapper implements Function<EmployeeEntity, EmployeeDTO> {

    @Override
    public EmployeeDTO apply(EmployeeEntity employeeEntity) {
        return new EmployeeDTO(
                employeeEntity.getRut(),
                employeeEntity.getSalary(),
                employeeEntity.getName(),
                employeeEntity.getSurname(),
                employeeEntity.getSecondSurname(),
                employeeEntity.getPhoneNumber(),
                employeeEntity.getEmail(),
                employeeEntity.getBirthday(),
                employeeEntity.getAge(),
                employeeEntity.getNationality(),
                employeeEntity.getPosition(),
                employeeEntity.getContract()
        );
    }
}
