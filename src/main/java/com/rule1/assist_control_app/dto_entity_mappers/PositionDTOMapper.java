package com.rule1.assist_control_app.dto_entity_mappers;

import com.rule1.assist_control_app.dto.PositionDTO;
import com.rule1.assist_control_app.entity.PositionEntity;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class PositionDTOMapper implements Function<PositionEntity, PositionDTO> {

    @Override
    public PositionDTO apply(PositionEntity positionEntity) {
        return new PositionDTO(positionEntity.getPositionType());
    }
}
