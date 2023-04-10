package com.schedule.barbershop;

import com.schedule.barbershop.model.Appointment;
import com.schedule.barbershop.model.Client;
import com.schedule.barbershop.model.Professional;
import com.schedule.barbershop.repository.AppointmentRepository;

import com.schedule.barbershop.sevice.AppointmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService appointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    public void shouldReturnAllAppointments() {
        Client client = new Client();
        client.setId(1L);
        client.setName("John Doe");
        client.setPhoneNumber("1234567890");

        Professional professional = new Professional();
        professional.setId(2L);
        professional.setName("Jane Doe");

        Appointment appointment1 = new Appointment();
        appointment1.setId(1L);
        appointment1.setClient(client);
        appointment1.setProfessional(professional);
        appointment1.setDateTime(LocalDateTime.now());
        appointment1.setDateTime(LocalDateTime.now().plusHours(1));

        Appointment appointment2 = new Appointment();
        appointment2.setId(2L);
        appointment2.setClient(client);
        appointment2.setProfessional(professional);
        appointment2.setDateTime(LocalDateTime.now().plusHours(2));
        appointment2.setDateTime(LocalDateTime.now().plusHours(3));

        when(appointmentRepository.findAll()).thenReturn(Arrays.asList(appointment1, appointment2));

        List<Appointment> appointments = appointmentService.findAll();

        assertThat(appointments).isNotNull();
        assertThat(appointments.size()).isEqualTo(2);
        assertThat(appointments.get(0).getId()).isEqualTo(appointment1.getId());
        assertThat(appointments.get(1).getId()).isEqualTo(appointment2.getId());

        verify(appointmentRepository, times(1)).findAll();
    }
}
