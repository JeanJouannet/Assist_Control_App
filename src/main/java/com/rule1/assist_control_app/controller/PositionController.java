package com.rule1.assist_control_app.controller;

import com.rule1.assist_control_app.dto.PositionDTO;
import com.rule1.assist_control_app.entity.PositionEntity;
import com.rule1.assist_control_app.service.impl.PositionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Assist_Control/")
public class PositionController {

    private final PositionServiceImpl positionServiceImpl;

    public PositionController(PositionServiceImpl positionServiceImpl) {
        this.positionServiceImpl = positionServiceImpl;
    }


    @CrossOrigin
    @PostMapping("/saveNewPosition")
    public ResponseEntity<PositionEntity> saveNewPosition (@RequestBody PositionDTO positionDTO) {
        return ResponseEntity.ok(positionServiceImpl.saveNewPosition(positionDTO));
    }
    @CrossOrigin
    @GetMapping("/positions")
    public ResponseEntity<List<PositionDTO>> positions() {
        return ResponseEntity.ok(positionServiceImpl.getAllPositions());
    }

    @CrossOrigin
    @GetMapping("/getUniquePositions")
    public ResponseEntity<List<String>> uniqueContracts() {
        return ResponseEntity.ok(positionServiceImpl.getUniquePositionTypes());
    }
}
