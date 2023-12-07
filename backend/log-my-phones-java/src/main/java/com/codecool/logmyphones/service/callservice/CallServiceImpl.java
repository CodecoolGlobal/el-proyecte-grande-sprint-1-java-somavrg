package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.*;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.DTO.NewCallDTO;
import com.codecool.logmyphones.model.repository.CallRepository;
import com.codecool.logmyphones.model.repository.ClientPhoneRepository;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.security.JwtService;
import com.codecool.logmyphones.service.mapper.CallMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CallServiceImpl implements CallService {
    private final CallRepository callRepository;
    private final DispatcherRepository dispatcherRepository;
    private final ClientPhoneRepository clientPhoneRepository;
    private final CallMapper callMapper;
    private final JwtService jwtService;

    public CallServiceImpl(CallRepository callRepository, DispatcherRepository dispatcherRepository, ClientPhoneRepository clientPhoneRepository, CallMapper callMapper, JwtService jwtService) {
        this.callRepository = callRepository;
        this.dispatcherRepository = dispatcherRepository;
        this.clientPhoneRepository = clientPhoneRepository;
        this.callMapper = callMapper;
        this.jwtService = jwtService;
    }

    @Override
    public List<CallDTO> getCalls(String token) {
        String userEmail = jwtService.extractUsername(token.split(" ")[1]);
        Set<Dispatcher> dispatchers = dispatcherRepository.findByUser_Email(userEmail);
        List<Call> calls = new ArrayList<>();

        dispatchers.forEach(dispatcher ->
                calls.addAll(callRepository.findCallsByDispatcherId(dispatcher.getId())));

        return callMapper.toCallDTOs(calls);
    }

    @Override
    public ResponseEntity<List<CallDTO>> getCallsByDispatchers(Set<Long> dispatcherIds) {
        List<Call> calls = new ArrayList<>();
        dispatcherIds.forEach(id -> calls.addAll(callRepository.findCallsByDispatcherId(id)));
        return new ResponseEntity<>(callMapper.toCallDTOs(calls), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CallDTO>> getCallsByStatus(String token, CallStatus callStatus) {
        Set<Dispatcher> dispatchers = dispatcherRepository.findByUser_Email(token.split(" ")[1]);
        List<Call> calls = new ArrayList<>();
        dispatchers.forEach(dispatcher -> calls.addAll(callRepository.getCallsByDispatcherIdAndCallStatus(dispatcher.getId(),callStatus)));
        return new ResponseEntity<>(callMapper.toCallDTOs(calls), HttpStatus.OK);
    }

    @Override
    @Transactional
    public CallDTO addNewCall(NewCallDTO newCallDTO) {

        if (newCallDTO.duration() < 0) {
            throw new IllegalArgumentException("Call duration cannot be negative number.");
        }

        Dispatcher dispatcher = dispatcherRepository.findByPhoneNumber(newCallDTO.dispatcherPhoneNumber())
                .orElseThrow(() -> new EntityNotFoundException("There is no dispatcher with this phone number."));
        ClientPhone clientPhone = clientPhoneRepository.findByPhoneNumber(newCallDTO.clientPhoneNumber())
                .orElse(
                        clientPhoneRepository.save(createNewClientPhone(newCallDTO.clientPhoneNumber()))
                );

        Call newCall = callRepository.save(callMapper.toCall(newCallDTO, dispatcher, clientPhone));

        return callMapper.toCallDTO(newCall);
    }

    private ClientPhone createNewClientPhone(String clientPhoneNumber){
        return ClientPhone.builder()
                .phoneNumber(clientPhoneNumber)
                .build();
    }
}
