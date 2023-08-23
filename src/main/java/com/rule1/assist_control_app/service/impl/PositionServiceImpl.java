package com.rule1.assist_control_app.service.impl;

import com.rule1.assist_control_app.dto.PositionDTO;
import com.rule1.assist_control_app.builder.BuildPositionEntity;
import com.rule1.assist_control_app.dto_mappers.PositionDTOMapper;
import com.rule1.assist_control_app.entity.PositionEntity;
import com.rule1.assist_control_app.repository.PositionRepository;
import com.rule1.assist_control_app.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionDTOMapper positionDTOMapper;

    private final BuildPositionEntity buildPositionEntity;


    public PositionServiceImpl(PositionRepository positionRepository, PositionDTOMapper positionDTOMapper, BuildPositionEntity buildPositionEntity) {
        this.positionRepository = positionRepository;
        this.positionDTOMapper = positionDTOMapper;
        this.buildPositionEntity = buildPositionEntity;
    }

    @Override
    public PositionEntity saveNewPosition(PositionDTO positionDTO) {
        return positionRepository.save(buildPositionEntity.buildPosition(positionDTO));
    }

    @Override
    public List<PositionDTO> getAllPositions() {
        return positionRepository.findAll()
                .stream()
                .map(positionDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
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


