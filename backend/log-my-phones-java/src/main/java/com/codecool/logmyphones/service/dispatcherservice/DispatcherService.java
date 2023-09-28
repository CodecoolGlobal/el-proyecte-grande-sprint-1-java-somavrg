package com.codecool.logmyphones.service.dispatcherservice;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;

import java.util.Set;

public interface DispatcherService {
    Set<DispatcherDTO> getAllDispatchers();
    DispatcherDTO getDispatcherById(Long id);
    void addNewDispatcher(DispatcherDTO dispatcherDTO);
    void updateDispatcher(Long id, DispatcherDTO dispatcherDTO);
    void deleteDispatcher(Long id);
}
