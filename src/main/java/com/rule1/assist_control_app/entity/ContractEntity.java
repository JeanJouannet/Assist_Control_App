package com.rule1.assist_control_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contract")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "contract_type")
    private String contractType;

    @Column(name = "salary")
    private Integer salary;

    public ContractEntity(String contractType) {
        this.contractType = contractType;
    }

    public ContractEntity() {
    }

    public Long getContractId() {
        return contractId;
    }

    public String getContractType() {
        return contractType;
    }


    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}



