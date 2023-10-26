package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.*;
import com.codecool.logmyphones.model.DTO.NewCallDTO;
import com.codecool.logmyphones.model.repository.CallRepository;
import com.codecool.logmyphones.model.repository.ClientPhoneRepository;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.service.mapper.CallMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CallServiceImplTest {
    @Mock
    private DispatcherRepository dispatcherRepository;
    @Mock
    private ClientPhoneRepository clientPhoneRepository;
    @Mock
    private CallRepository callRepository;
    @Mock
    private CallMapper callMapper;
    @InjectMocks
    private CallServiceImpl callService;

    @Test
    public void testAddNewCallThrowsExceptionWhenDispatcherIsNotFoundByPhoneNumber() {
        NewCallDTO newCallDTO = new NewCallDTO(
                "123",
                "345",
                LocalDateTime.now(),
                CallStatus.ONGOING,
                CallDirection.INCOMING,
                0
        );

        Mockito.when(dispatcherRepository.findByPhoneNumber(newCallDTO.dispatcherPhoneNumber())).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class, () -> callService.addNewCall(newCallDTO));
    }

    @Test
    public void testAddNewCallCreatesNewClientPhoneIfNotFoundByPhoneNumber() {
        NewCallDTO newCallDTO = new NewCallDTO(
                "123",
                "345",
                LocalDateTime.now(),
                CallStatus.ONGOING,
                CallDirection.INCOMING,
                0
        );
        Mockito.when(dispatcherRepository.findByPhoneNumber(newCallDTO.dispatcherPhoneNumber())).thenReturn(Optional.of(new Dispatcher()));
        Mockito.when(clientPhoneRepository.findByPhoneNumber(newCallDTO.clientPhoneNumber())).thenReturn(Optional.empty());

        ClientPhone newClientPhone = ClientPhone.builder().phoneNumber("345").build();

        callService.addNewCall(newCallDTO);

        verify(clientPhoneRepository, times(1)).save(newClientPhone);
    }

}