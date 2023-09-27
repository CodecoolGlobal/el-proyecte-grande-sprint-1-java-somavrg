package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;

import java.util.Set;

public interface CallService {
    Set<Call> getCalls(Long companyId);
    Set<Call> getCallsByDispatchers(Long companyId,Set<Long> dispatcherId);
    Set<Call> getCallsByStatus(CallStatus callStatus);
}
