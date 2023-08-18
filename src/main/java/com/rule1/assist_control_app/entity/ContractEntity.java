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

    public ContractEntity(Long contractId, String contractType) {
        this.contractId = contractId;
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

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}

