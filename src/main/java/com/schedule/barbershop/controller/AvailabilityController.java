package com.schedule.barbershop.controller;


import com.schedule.barbershop.model.Availability;
import com.schedule.barbershop.sevice.AvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/availabilities")
@CrossOrigin(origins = "*")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailabilities() {
        return ResponseEntity.ok(availabilityService.findAll());
    }

    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        return ResponseEntity.ok(availabilityService.save(availability));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable Long id, @RequestBody Availability availability) {
        Availability existingAvailability = availabilityService.findById(id);
        existingAvailability.setProfessional(availability.getProfessional());
        existingAvailability.setStartDate(availability.getStartDate());
        existingAvailability.setEndDate(availability.getEndDate());
        existingAvailability.setStartTime(availability.getStartTime());
        existingAvailability.setEndTime(availability.getEndTime());
        existingAvailability.setDaysOfWeek(availability.getDaysOfWeek());
        return ResponseEntity.ok(availabilityService.save(existingAvailability));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
