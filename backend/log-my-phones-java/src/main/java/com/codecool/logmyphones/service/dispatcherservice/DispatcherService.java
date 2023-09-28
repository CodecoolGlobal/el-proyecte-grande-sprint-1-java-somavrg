package com.codecool.logmyphones.service.dispatcherservice;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;

import java.util.Set;

public interface DispatcherService {
    Set<DispatcherDTO> getAllDispatchers(Long companyId);
    DispatcherDTO getDispatcherById(Long id);
    void addNewDispatcher(NewDispatcherDTO dispatcherDTO);
    void updateDispatcher(Long id, DispatcherDTO dispatcherDTO);
    void deleteDispatcher(Long id);
}
