package com.codecool.logmyphones.service.dispatcherservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.service.mapper.DispatcherMapper;
import com.codecool.logmyphones.service.mapper.NewDispatcherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DispatcherServiceImpl implements DispatcherService {
    private final DispatcherRepository dispatcherRepository;
    private final DispatcherMapper dispatcherMapper;
    private final UserRepository userRepository;
    private final NewDispatcherMapper newDispatcherMapper;

    @Autowired
    public DispatcherServiceImpl(DispatcherRepository dispatcherRepository, DispatcherMapper dispatcherMapper, UserRepository userRepository, NewDispatcherMapper newDispatcherMapper) {
        this.dispatcherRepository = dispatcherRepository;
        this.dispatcherMapper = dispatcherMapper;
        this.userRepository = userRepository;
        this.newDispatcherMapper = newDispatcherMapper;
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
    public void addNewDispatcher(NewDispatcherDTO dispatcherDTO) {
        CompanyUser user = userRepository.getById(dispatcherDTO.userUserId());
        Dispatcher dispatcher = newDispatcherMapper.toDispatcher(dispatcherDTO);
        dispatcher.setUser(user);
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