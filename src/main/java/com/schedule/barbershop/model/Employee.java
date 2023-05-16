package com.schedule.barbershop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    private Long id;

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private LocalDate admissionDate;

    private String maritalStatus;

    @OneToOne
    @MapsId
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Availability> availability;

}


