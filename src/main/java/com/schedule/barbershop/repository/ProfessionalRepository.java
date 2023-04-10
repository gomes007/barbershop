package com.schedule.barbershop.repository;

import com.schedule.barbershop.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}
