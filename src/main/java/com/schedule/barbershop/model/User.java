package com.schedule.barbershop.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Email
    @Column(unique=true)
    private String email;

    @NotBlank
    private String password;

    @ManyToOne
    @Setter
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Employee employee;


}



