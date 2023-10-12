package com.codecool.logmyphones.service.dispatcherservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.security.JwtService;
import com.codecool.logmyphones.service.mapper.DispatcherMapper;
import com.codecool.logmyphones.service.mapper.NewDispatcherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DispatcherServiceImpl implements DispatcherService {
    private final DispatcherRepository dispatcherRepository;
    private final DispatcherMapper dispatcherMapper;
    private final UserRepository userRepository;
    private final NewDispatcherMapper newDispatcherMapper;
    private final JwtService jwtService;

    @Autowired
    public DispatcherServiceImpl(DispatcherRepository dispatcherRepository, DispatcherMapper dispatcherMapper, UserRepository userRepository, NewDispatcherMapper newDispatcherMapper, JwtService jwtService) {
        this.dispatcherRepository = dispatcherRepository;
        this.dispatcherMapper = dispatcherMapper;
        this.userRepository = userRepository;
        this.newDispatcherMapper = newDispatcherMapper;
        this.jwtService = jwtService;
    }

    @Override
    public ResponseEntity<Set<DispatcherDTO>> getAllDispatchers(String token) {
        String companyEmail = jwtService.extractUsername(token.split(" ")[1]);
        System.out.println(companyEmail);
        return new ResponseEntity<>(
                dispatcherMapper.toDispatcherDTOs(dispatcherRepository.getDispatchersByUser_Email(companyEmail)),
                HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<DispatcherDTO> getDispatcherById(Long id) {
        return new ResponseEntity<>(dispatcherMapper.toDispatcherDTO(dispatcherRepository.getById(id)), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<NewDispatcherDTO> addNewDispatcher(NewDispatcherDTO dispatcherDTO) {
        CompanyUser user = userRepository.getById(dispatcherDTO.userUserId());
        Dispatcher dispatcher = newDispatcherMapper.toDispatcher(dispatcherDTO);
        dispatcher.setUser(user);
        dispatcher.setCalls(new HashSet<>());
        dispatcherRepository.save(dispatcher);
        return new ResponseEntity<>(dispatcherDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DispatcherDTO> updateDispatcher(Long id, DispatcherDTO dispatcherDTO) {
        return null;
    }

    @Override
    public HttpStatus deleteDispatcher(Long id) {
        dispatcherRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
