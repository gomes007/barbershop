package com.schedule.barbershop.sevice;

import com.schedule.barbershop.model.Professional;
import com.schedule.barbershop.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    public Professional save(Professional professional) {
        return professionalRepository.save(professional);
    }
}
