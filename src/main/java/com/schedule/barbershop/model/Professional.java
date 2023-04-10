package com.schedule.barbershop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professional")
@Data
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL)
    private List<Availability> availability;


}
