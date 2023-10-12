package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CallService {
    ResponseEntity<Set<CallDTO>> getCalls(Long userId);
    ResponseEntity<Set<CallDTO>> getCallsByDispatchers(Long companyId,Set<Long> dispatcherId);
    ResponseEntity<Set<CallDTO>> getCallsByStatus(Long userId,CallStatus callStatus);
    ResponseEntity<CallDTO> addNewCall(CallDTO call);
}
