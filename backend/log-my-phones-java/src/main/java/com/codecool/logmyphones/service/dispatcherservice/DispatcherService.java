package com.codecool.logmyphones.service.dispatcherservice;

import com.codecool.logmyphones.authentication.AuthenticationResponse;
import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface DispatcherService {
    ResponseEntity<Set<DispatcherDTO>> getAllDispatchers(String token);
    ResponseEntity<DispatcherDTO> getDispatcherById(Long id);
    ResponseEntity<NewDispatcherDTO> addNewDispatcher(NewDispatcherDTO dispatcherDTO);
    ResponseEntity<DispatcherDTO> updateDispatcher(Long id, DispatcherDTO dispatcherDTO);
    HttpStatus deleteDispatcher(Long id);
}
