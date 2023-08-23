package com.rule1.assist_control_app.builder;

import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

@Service
public class BuildEmployeeEntity {
    public EmployeeEntity buildEmployee(EmployeeDTO employeeDTO){
        return new EmployeeEntity(
                employeeDTO.rut(),
                employeeDTO.name(),
                employeeDTO.surname(),
                employeeDTO.secondSurname(),
                employeeDTO.phoneNumber(),
                employeeDTO.email(),
                employeeDTO.birthday(),
                employeeDTO.age(),
                employeeDTO.nationality(),
                employeeDTO.salary(),
                employeeDTO.position(),
                employeeDTO.contract()
                );
    }

}
