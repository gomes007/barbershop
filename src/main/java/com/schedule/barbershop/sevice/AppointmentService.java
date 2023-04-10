package com.schedule.barbershop.sevice;

import com.schedule.barbershop.model.Appointment;
import com.schedule.barbershop.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAvailableTimeSlots(Long professionalId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findAllByProfessionalIdAndDateTimeBetween(professionalId, start, end);
    }
}
