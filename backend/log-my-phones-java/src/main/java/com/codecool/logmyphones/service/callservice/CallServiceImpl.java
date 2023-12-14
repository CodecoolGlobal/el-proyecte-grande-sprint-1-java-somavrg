package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.*;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.DTO.CallResponse;
import com.codecool.logmyphones.model.DTO.NewCallDTO;
import com.codecool.logmyphones.model.repository.CallRepository;
import com.codecool.logmyphones.model.repository.ClientPhoneRepository;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.security.JwtService;
import com.codecool.logmyphones.service.mapper.CallMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    public CallResponse getCalls(String token, int pageNo, int pageSize, CallDirection callDirection) {
        String userEmail = jwtService.extractUsername(token.split(" ")[1]);
        Set<Long> dispatcherIds = dispatcherRepository.findByUser_Email(userEmail).stream()
                .map(Dispatcher::getId).collect(Collectors.toSet());

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Call> calls;

        if (callDirection == null) {
            calls = callRepository.findCallsByDispatcherIdIn(dispatcherIds, pageable);
        } else {
            calls = callRepository.findCallsByDispatcherIdInAndCallDirection(dispatcherIds, callDirection, pageable);
        }

        List<CallDTO> content = calls.map(callMapper::toCallDTO).getContent();

        CallResponse callResponse = new CallResponse();
        callResponse.setContent(content);
        callResponse.setPageNo(calls.getNumber());
        callResponse.setPageSize(calls.getSize());
        callResponse.setTotalElements(calls.getTotalElements());
        callResponse.setTotalPages(calls.getTotalPages());
        callResponse.setLast(calls.isLast());

        return callResponse;
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
