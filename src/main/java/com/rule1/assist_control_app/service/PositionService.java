package com.rule1.assist_control_app.service;

import com.rule1.assist_control_app.dto.PositionDTO;
import com.rule1.assist_control_app.entity.PositionEntity;

import java.util.List;

public interface PositionService {


    public PositionEntity saveNewPosition(PositionDTO positionDTO);

    public List<PositionDTO> getAllPositions();

    public List<String> getUniquePositionTypes();
}
