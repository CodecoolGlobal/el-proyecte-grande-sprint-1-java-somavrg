package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.repository.CallRepository;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
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

    @Autowired
    public CallServiceImpl(CallRepository callRepository, DispatcherRepository dispatcherRepository, CallMapper callMapper) {
        this.callRepository = callRepository;
        this.dispatcherRepository = dispatcherRepository;
        this.callMapper = callMapper;
    }

    @Override
    public ResponseEntity<Set<CallDTO>> getCalls(Long userId) {
        Set<Dispatcher> dispatchers = dispatcherRepository.getDispatchersByUserUserId(userId);
        Set<Call> calls = new HashSet<>();
        dispatchers.forEach(dispatcher -> calls.addAll(callRepository.getCallsByDispatcherDispatcherId(dispatcher.getDispatcherId())));
        return new ResponseEntity<>(callMapper.toCallDTOs(calls), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<CallDTO>> getCallsByDispatchers(Long userId, Set<Long> dispatcherIds) {
        Set<Call> calls = new HashSet<>();
        dispatcherIds.forEach(dispatcherId -> calls.addAll(callRepository.getCallsByDispatcherDispatcherId(dispatcherId)));
        return new ResponseEntity<>(callMapper.toCallDTOs(calls), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<CallDTO>> getCallsByStatus(Long userId, CallStatus callStatus) {
        Set<Dispatcher> dispatchers = dispatcherRepository.getDispatchersByUserUserId(userId);
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
