package com.schedule.barbershop.repository;

import com.schedule.barbershop.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByEmployeeIdAndDateTimeBetween(Long professionalId, LocalDateTime start, LocalDateTime end);

}
