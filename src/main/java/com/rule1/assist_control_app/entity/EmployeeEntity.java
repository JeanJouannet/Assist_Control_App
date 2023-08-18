package com.rule1.assist_control_app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "employee", schema = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "rut")
    private String rut;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "second_surname")
    private String secondSurname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Transient
    private Integer age;

    @Column(name = "nationality")
    private String nationality;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_position_id")
    private PositionEntity position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_contract_id")
    private ContractEntity contract;

    public EmployeeEntity(String rut, Integer salary, String name, String surname, String secondSurname, String phoneNumber, LocalDate birthday, Integer age, String nationality, PositionEntity position, ContractEntity contract) {
        this.rut = rut;
        this.salary = salary;
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.contract = contract;
    }

    public EmployeeEntity() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate bornDate) {
        this.birthday = bornDate;
    }

    public Integer getAge() {
        LocalDate birthdate = getBirthday();
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthdate, today);
        return period.getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public void setPositionId(PositionEntity position) {
        this.position = position;
    }

    public ContractEntity getContract() {
        return contract;
    }

    public void setContractId(ContractEntity contract) {
        this.contract = contract;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
