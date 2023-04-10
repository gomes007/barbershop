package com.schedule.barbershop;

import com.schedule.barbershop.model.Professional;
import com.schedule.barbershop.repository.ProfessionalRepository;
import com.schedule.barbershop.sevice.ProfessionalService;
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
public class ProfessionalServiceTest {

    @InjectMocks
    private ProfessionalService professionalService;

    @Mock
    private ProfessionalRepository professionalRepository;

    @Test
    public void shouldReturnAllProfessionals() {
        Professional professional1 = new Professional();
        professional1.setId(1L);
        professional1.setName("Barber Joe");

        Professional professional2 = new Professional();
        professional2.setId(2L);
        professional2.setName("Barber Jane");

        List<Professional> professionals = Arrays.asList(professional1, professional2);

        when(professionalRepository.findAll()).thenReturn(professionals);

        List<Professional> result = professionalService.findAll();
        assertThat(result).isEqualTo(professionals);

        verify(professionalRepository, times(1)).findAll();
    }
}

