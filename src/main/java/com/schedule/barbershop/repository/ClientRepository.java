package com.schedule.barbershop.repository;

import com.schedule.barbershop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
