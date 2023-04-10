package com.schedule.barbershop.controller;

import com.schedule.barbershop.model.Professional;
import com.schedule.barbershop.sevice.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
@CrossOrigin(origins = "*")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @GetMapping
    public ResponseEntity<List<Professional>> getAllProfessionals() {
        return ResponseEntity.ok(professionalService.findAll());
    }

    @PostMapping
    public ResponseEntity<Professional> createProfessional(@RequestBody Professional professional) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professionalService.save(professional));
    }
}

