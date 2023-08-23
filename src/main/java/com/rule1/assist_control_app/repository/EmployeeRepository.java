package com.rule1.assist_control_app.repository;

import com.rule1.assist_control_app.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity deleteByRut(String s);

    Optional<EmployeeEntity> findByRut(String rut);
}

