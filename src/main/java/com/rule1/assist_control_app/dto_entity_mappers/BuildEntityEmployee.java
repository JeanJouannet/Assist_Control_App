package com.rule1.assist_control_app.dto_entity_mappers;

import com.rule1.assist_control_app.dto.EmployeeDTO;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

@Service
public class BuildEntityEmployee {
    public EmployeeEntity buildEmployee(EmployeeDTO employeeDTO){
        return new EmployeeEntity(
                employeeDTO.rut(),
                employeeDTO.salary(),
                employeeDTO.name(),
                employeeDTO.surname(),
                employeeDTO.secondSurname(),
                employeeDTO.phoneNumber(),
                employeeDTO.birthday(),
                employeeDTO.age(),
                employeeDTO.nationality(),
                employeeDTO.position(),
                employeeDTO.contract()
                );
    }

}
