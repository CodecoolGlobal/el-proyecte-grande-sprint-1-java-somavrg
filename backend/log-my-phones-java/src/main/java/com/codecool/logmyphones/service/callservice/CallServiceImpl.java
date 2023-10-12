package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.authentication.AuthenticationResponse;
import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.repository.CallRepository;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.security.JwtService;
import com.codecool.logmyphones.service.mapper.CallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CallServiceImpl implements CallService {
    private final CallRepository callRepository;
    private final DispatcherRepository dispatcherRepository;
    private final CallMapper callMapper;
    private final JwtService jwtService;

    @Autowired
    public CallServiceImpl(CallRepository callRepository, DispatcherRepository dispatcherRepository, CallMapper callMapper, JwtService jwtService) {
        this.callRepository = callRepository;
        this.dispatcherRepository = dispatcherRepository;
        this.callMapper = callMapper;
        this.jwtService = jwtService;
    }

    @Override
    public ResponseEntity<Set<CallDTO>> getCalls(String token) {
        Long userId = Long.valueOf(jwtService.extractUsername(token.split(" ")[1]));
        Set<Dispatcher> dispatchers = dispatcherRepository.getDispatchersByUserUserId(userId);
        Set<Call> calls = new HashSet<>();
        dispatchers.forEach(dispatcher -> calls.addAll(callRepository.getCallsByDispatcherDispatcherId(dispatcher.getDispatcherId())));
        return new ResponseEntity<>(callMapper.toCallDTOs(calls), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<CallDTO>> getCallsByDispatchers(Set<Long> dispatcherIds) {
        Set<Call> calls = new HashSet<>();
        dispatcherIds.forEach(dispatcherId -> calls.addAll(callRepository.getCallsByDispatcherDispatcherId(dispatcherId)));
        return new ResponseEntity<>(callMapper.toCallDTOs(calls), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<CallDTO>> getCallsByStatus(String token, CallStatus callStatus) {
        Set<Dispatcher> dispatchers = dispatcherRepository.getDispatchersByUser_Email(token.split(" ")[1]);
        Set<Call> calls = new HashSet<>();
        dispatchers.forEach(dispatcher -> calls.addAll(callRepository.getCallsByDispatcherDispatcherIdAndCallStatus(dispatcher.getDispatcherId(),callStatus)));
        return new ResponseEntity<>(callMapper.toCallDTOs(calls), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CallDTO> addNewCall(CallDTO call) {
        callRepository.save(callMapper.toCall(call));
        return new ResponseEntity<>(call, HttpStatus.OK);
    }
}
