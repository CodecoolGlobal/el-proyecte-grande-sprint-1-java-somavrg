package com.codecool.logmyphones.service.dispatcherservice;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.service.mapper.DispatcherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DispatcherServiceImpl implements DispatcherService {
    private final DispatcherRepository dispatcherRepository;
    private final DispatcherMapper dispatcherMapper;

    @Autowired
    public DispatcherServiceImpl(DispatcherRepository dispatcherRepository, DispatcherMapper dispatcherMapper) {
        this.dispatcherRepository = dispatcherRepository;
        this.dispatcherMapper = dispatcherMapper;
    }

    @Override
    public Set<DispatcherDTO> getAllDispatchers(Long companyId) {
        return dispatcherMapper.toDispatcherDTOs(dispatcherRepository.getDispatchersByUserUserId(companyId));
    }

    @Override
    public DispatcherDTO getDispatcherById(Long id) {
        return dispatcherMapper.toDispatcherDTO(dispatcherRepository.getById(id));
    }

    @Override
    public void addNewDispatcher(DispatcherDTO dispatcherDTO) {
        Dispatcher dispatcher = dispatcherMapper.toDispatcher(dispatcherDTO);
        dispatcher.setCalls(new HashSet<>());
        dispatcherRepository.save(dispatcher);
    }

    @Override
    public void updateDispatcher(Long id, DispatcherDTO dispatcherDTO) {

    }

    @Override
    public void deleteDispatcher(Long id) {
        dispatcherRepository.deleteById(id);
    }
}
