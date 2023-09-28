package com.codecool.logmyphones.service.dispatcherservice;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DispatcherServiceImpl implements DispatcherService {
    private final DispatcherRepository dispatcherRepository;

    @Autowired
    public DispatcherServiceImpl(DispatcherRepository dispatcherRepository) {
        this.dispatcherRepository = dispatcherRepository;
    }

    @Override
    public Set<DispatcherDTO> getAllDispatchers() {
        return dispatcherRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public DispatcherDTO getDispatcherById(Long id) {
        return dispatcherRepository.getById(id);
    }

    @Override
    public void addNewDispatcher(DispatcherDTO dispatcherDTO) {
        dispatcherRepository.save(dispatcherDTO);
    }

    @Override
    public void updateDispatcher(Long id, DispatcherDTO dispatcherDTO) {

    }

    @Override
    public void deleteDispatcher(Long id) {
        dispatcherRepository.deleteById(id);
    }
}
