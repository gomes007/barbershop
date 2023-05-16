package com.schedule.barbershop.sevice;

import com.schedule.barbershop.model.Employee;
import com.schedule.barbershop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee professional) {
        return employeeRepository.save(professional);
    }
}
