package com.rule1.assist_control_app.repository;

import com.rule1.assist_control_app.entity.ContractEntity;
import com.rule1.assist_control_app.entity.EmployeeEntity;
import com.rule1.assist_control_app.entity.PositionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;


public class EmployeeRepTest {


private  EmployeeRepository employeeRepository;


    /* TODO try to make this work, it doesnt connect to the date base for some reason */
    @Test
    public void testSaveEmployee(){
        //given condition or config
        LocalDate birthDate;
        EmployeeEntity employee1 = new EmployeeEntity(
                "10.100.000-k",
                "Jean",
                "Jouannet",
                "Valdebenito",
                "jeanjouannet98@gmail.com",
                "",
                LocalDate.of(1998,3,22),
                25,
                "Chilena",
                100000,
                new PositionEntity("Developer"),
                new ContractEntity("Completo"));

        //when action or behavior
        EmployeeEntity savedEmployee = employeeRepository.save(employee1);

        //then verify exit
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getEmployeeId()).isGreaterThan(0);

    }

}
