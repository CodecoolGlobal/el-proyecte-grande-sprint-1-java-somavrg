package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.authentication.AuthenticationResponse;
import com.codecool.logmyphones.model.DTO.DispatcherDTO;

import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;
import com.codecool.logmyphones.service.dispatcherservice.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/dispatchers")
public class DispatcherController {
    private final DispatcherService dispatcherService;

    @Autowired
    public DispatcherController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @GetMapping
    public ResponseEntity<Set<DispatcherDTO>> getAllDispatchersByCompany(@RequestHeader("Authorization") String token) {
        return dispatcherService.getAllDispatchers(token);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DispatcherDTO> getDispatcherById(@PathVariable Long id) {
        return dispatcherService.getDispatcherById(id);
    }

    @PostMapping
    public ResponseEntity<NewDispatcherDTO> addNewDispatcher(@RequestBody NewDispatcherDTO dispatcher) {
        return dispatcherService.addNewDispatcher(dispatcher);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DispatcherDTO> updateDispatcherById(@PathVariable Long id,
                                     @RequestBody DispatcherDTO dispatcherUpdate) {
        return dispatcherService.updateDispatcher(id, dispatcherUpdate);
    }

    // TODO ...
    @DeleteMapping("/{id}")
    public HttpStatus deleteDispatcher(@PathVariable Long id) {
       return dispatcherService.deleteDispatcher(id);
    }
}

