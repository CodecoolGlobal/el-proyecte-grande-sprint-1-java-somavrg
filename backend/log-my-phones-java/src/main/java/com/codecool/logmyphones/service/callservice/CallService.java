package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.authentication.AuthenticationResponse;
import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallDirection;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.DTO.CallResponse;
import com.codecool.logmyphones.model.DTO.NewCallDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface CallService {
    CallResponse getCalls(String token, int pageNo, int pageSize, CallDirection callDirection);
    ResponseEntity<List<CallDTO>> getCallsByDispatchers(Set<Long> id);
    ResponseEntity<List<CallDTO>> getCallsByStatus(String token,CallStatus callStatus);
    CallDTO addNewCall(NewCallDTO newCallDTO);
}
