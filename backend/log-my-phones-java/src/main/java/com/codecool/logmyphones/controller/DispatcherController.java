package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;

import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;
import com.codecool.logmyphones.service.dispatcherservice.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{companyId}")
    public Set<DispatcherDTO> getAllDispatchersByCompany(@PathVariable Long companyId) {
        return dispatcherService.getAllDispatchers(companyId);
    }

    @GetMapping("/dispatcher/{id}")
    public DispatcherDTO getDispatcherById(@PathVariable Long id) {
        return dispatcherService.getDispatcherById(id);
    }

    @PostMapping
    public void addNewDispatcher(@RequestBody NewDispatcherDTO dispatcher) {
        dispatcherService.addNewDispatcher(dispatcher);
    }

    @PatchMapping("/dispatcher/{id}")
    public void updateDispatcherById(@PathVariable Long id,
                                     @RequestBody DispatcherDTO dispatcherUpdate) {
        dispatcherService.updateDispatcher(id, dispatcherUpdate);
    }

    @DeleteMapping("/dispatcher/{id}")
    public void deleteDispatcher(@PathVariable Long id) {
        dispatcherService.deleteDispatcher(id);
    }
}

