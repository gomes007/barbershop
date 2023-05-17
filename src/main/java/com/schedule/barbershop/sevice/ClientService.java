package com.schedule.barbershop.sevice;

import com.schedule.barbershop.model.Customer;
import com.schedule.barbershop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Customer> findAll() {
        return clientRepository.findAll();
    }

    public Customer save(Customer customer) {
        return clientRepository.save(customer);
    }

}
