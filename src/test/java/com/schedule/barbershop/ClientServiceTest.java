package com.schedule.barbershop;


import com.schedule.barbershop.model.Client;
import com.schedule.barbershop.repository.ClientRepository;
import com.schedule.barbershop.sevice.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void shouldReturnAllClients() {
        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("John Doe");
        client1.setPhoneNumber("1234567890");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("Jane Doe");
        client2.setPhoneNumber("0987654321");

        List<Client> clients = Arrays.asList(client1, client2);

        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.findAll();
        assertThat(result).isEqualTo(clients);

        verify(clientRepository, times(1)).findAll();
    }
}

