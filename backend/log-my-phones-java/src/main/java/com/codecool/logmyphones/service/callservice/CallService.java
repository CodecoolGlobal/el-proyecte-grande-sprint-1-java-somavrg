package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;

import java.util.Set;

public interface CallService {
    Set<CallDTO> getCalls(Long userId);
    Set<CallDTO> getCallsByDispatchers(Long companyId,Set<Long> dispatcherId);
    Set<CallDTO> getCallsByStatus(Long userId,CallStatus callStatus);
}
