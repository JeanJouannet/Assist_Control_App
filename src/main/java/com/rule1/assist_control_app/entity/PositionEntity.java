package com.rule1.assist_control_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "position_type")
    private String positionType;

    public PositionEntity(Long positionId, String positionType) {
        this.positionId = positionId;
        this.positionType = positionType;
    }

    public PositionEntity() {

    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
