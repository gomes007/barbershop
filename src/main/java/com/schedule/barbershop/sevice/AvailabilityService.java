package com.schedule.barbershop.sevice;


import com.schedule.barbershop.model.Availability;
import com.schedule.barbershop.repository.AvailabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    public List<Availability> findAll() {
        return availabilityRepository.findAll();
    }

    public Availability findById(Long id) {
        return availabilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Availability not found"));
    }

    public Availability save(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public void deleteById(Long id) {
        availabilityRepository.deleteById(id);
    }
}
