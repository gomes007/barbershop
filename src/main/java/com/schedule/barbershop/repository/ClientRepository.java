package com.schedule.barbershop.repository;

import com.schedule.barbershop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Customer, Long> {
}
