package com.schedule.barbershop.controller;

import com.schedule.barbershop.model.Appointment;
import com.schedule.barbershop.sevice.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.save(appointment));
    }

    @GetMapping("/availableTimeSlots")
    public ResponseEntity<List<Appointment>> getAvailableTimeSlots(@RequestParam Long professionalId,
                                                                   @RequestParam LocalDateTime start,
                                                                   @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(appointmentService.findAvailableTimeSlots(professionalId, start, end));
    }
}

