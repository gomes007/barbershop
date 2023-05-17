package com.schedule.barbershop.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phoneNumber;

}
