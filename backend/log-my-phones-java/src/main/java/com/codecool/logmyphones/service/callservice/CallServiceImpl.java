package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.DTO.PhoneDTO;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.repository.CallRepository;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CallServiceImpl implements CallService {
    private final CallRepository callRepository;
    private final DispatcherRepository dispatcherRepository;

    @Autowired
    public CallServiceImpl(CallRepository callRepository, DispatcherRepository dispatcherRepository) {
        this.callRepository = callRepository;
        this.dispatcherRepository = dispatcherRepository;
    }

    private CallDTO convertCallToCallDTO(Call call) {
        PhoneDTO phoneDTO = PhoneDTO.builder()
                .phoneNumber(call.getClient().getPhoneNumber()).build();
        return CallDTO.builder()
                .dispatcher(call.getDispatcher())
                .client(phoneDTO)
                .startTime(call.getStartTime())
                .callDirection(call.getCallDirection())
                .duration(call.getDuration()).build();
    }

    private Set<CallDTO> convertCallsToCallDTOs(Set<Call> calls) {
        Set<CallDTO> callDTOS = new HashSet<>();
        calls.forEach(call -> callDTOS.add(convertCallToCallDTO(call)));
        return callDTOS;
    }

    @Override
    public Set<CallDTO> getCalls(Long userId) {
        Set<Dispatcher> dispatchers = dispatcherRepository.getDispatchersByUserUserId(userId);
        Set<Call> calls = new HashSet<>();
        dispatchers.forEach(dispatcher -> calls.addAll(callRepository.getCallsByDispatcherDispatcherId(dispatcher.getDispatcherId())));
        return convertCallsToCallDTOs(calls);
    }

    @Override
    public Set<CallDTO> getCallsByDispatchers(Long userId, Set<Long> dispatcherIds) {
        Set<Call> calls = new HashSet<>();
        dispatcherIds.forEach(dispatcherId -> calls.addAll(callRepository.getCallsByDispatcherDispatcherId(dispatcherId)));
        return convertCallsToCallDTOs(calls);
    }

    @Override
    public Set<CallDTO> getCallsByStatus(Long userId, CallStatus callStatus) {
        Set<Dispatcher> dispatchers = dispatcherRepository.getDispatchersByUserUserId(userId);
        Set<Call> calls = new HashSet<>();
        dispatchers.forEach(dispatcher -> calls.addAll(callRepository.getCallsByDispatcherDispatcherIdAndCallStatus(dispatcher.getDispatcherId(),callStatus)));
        return convertCallsToCallDTOs(calls);
    }
}
