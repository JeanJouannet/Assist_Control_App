package com.rule1.assist_control_app.controller;

import com.rule1.assist_control_app.dto.PositionDTO;
import com.rule1.assist_control_app.service.PositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assist_Control/")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @CrossOrigin
    @GetMapping("/positions")
    public ResponseEntity<List<PositionDTO>> positions() {
        return ResponseEntity.ok(positionService.getAllPositions());
    }

    @CrossOrigin
    @GetMapping("/getUniquePositions")
    public ResponseEntity<List<String>> uniqueContracts() {
        return ResponseEntity.ok(positionService.getUniquePositionTypes());
    }
}
