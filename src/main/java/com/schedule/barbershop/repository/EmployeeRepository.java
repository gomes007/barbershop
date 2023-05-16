package com.schedule.barbershop.repository;

import com.schedule.barbershop.model.Employee;
import com.schedule.barbershop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUser(User adminUser);
}
