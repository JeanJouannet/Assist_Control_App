package com.rule1.assist_control_app.builder;
import com.rule1.assist_control_app.dto.PositionDTO;
import com.rule1.assist_control_app.entity.PositionEntity;
import org.springframework.stereotype.Service;

@Service
public class BuildPositionEntity {

    public PositionEntity buildPosition(PositionDTO positionDTO) {
        return new PositionEntity(
                positionDTO.positionType()
        );
    }
}
