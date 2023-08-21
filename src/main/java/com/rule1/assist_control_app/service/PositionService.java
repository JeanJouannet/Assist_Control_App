package com.rule1.assist_control_app.service;

import com.rule1.assist_control_app.dto.PositionDTO;
import com.rule1.assist_control_app.dto_entity_mappers.BuildPositionEntity;
import com.rule1.assist_control_app.dto_entity_mappers.PositionDTOMapper;
import com.rule1.assist_control_app.entity.PositionEntity;
import com.rule1.assist_control_app.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PositionService {

    private final PositionRepository positionRepository;
    private final PositionDTOMapper positionDTOMapper;

    private final BuildPositionEntity buildPositionEntity;


    public PositionService(PositionRepository positionRepository, PositionDTOMapper positionDTOMapper, BuildPositionEntity buildPositionEntity) {
        this.positionRepository = positionRepository;
        this.positionDTOMapper = positionDTOMapper;
        this.buildPositionEntity = buildPositionEntity;
    }

    public PositionEntity saveNewPosition(PositionDTO positionDTO) {
        return positionRepository.save(buildPositionEntity.buildPosition(positionDTO));
    }

    public List<PositionDTO> getAllPositions() {
        return positionRepository.findAll()
                .stream()
                .map(positionDTOMapper)
                .collect(Collectors.toList());
    }

    public List<String> getUniquePositionTypes() {
        List<PositionDTO> allPositions = positionRepository.findAll()
                .stream()
                .map(positionDTOMapper)
                .collect(Collectors.toList());

        Set<String> uniquePositionTypes = new HashSet<>();

        for (PositionDTO p : allPositions) {
            uniquePositionTypes.add(p.positionType());
        }

        return new ArrayList<>(uniquePositionTypes);
    }
}


