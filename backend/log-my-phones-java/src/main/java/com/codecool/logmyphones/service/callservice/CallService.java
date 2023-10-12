package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.authentication.AuthenticationResponse;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CallService {
    ResponseEntity<Set<CallDTO>> getCalls(String token);
    ResponseEntity<Set<CallDTO>> getCallsByDispatchers(Set<Long> dispatcherId);
    ResponseEntity<Set<CallDTO>> getCallsByStatus(String token,CallStatus callStatus);
    ResponseEntity<CallDTO> addNewCall(CallDTO call);
}
