package com.schedule.barbershop.repository;

import com.schedule.barbershop.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
}
