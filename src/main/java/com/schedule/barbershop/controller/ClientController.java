package com.schedule.barbershop.controller;

import com.schedule.barbershop.model.Customer;
import com.schedule.barbershop.sevice.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }


    @PostMapping
    public ResponseEntity<Customer> createClient(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(customer));
    }


}
