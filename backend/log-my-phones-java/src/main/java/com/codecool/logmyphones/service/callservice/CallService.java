package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.authentication.AuthenticationResponse;
import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.DTO.NewCallDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface CallService {
    List<CallDTO> getCalls(String token);
    ResponseEntity<List<CallDTO>> getCallsByDispatchers(Set<Long> id);
    ResponseEntity<List<CallDTO>> getCallsByStatus(String token,CallStatus callStatus);
    CallDTO addNewCall(NewCallDTO newCallDTO);
}
