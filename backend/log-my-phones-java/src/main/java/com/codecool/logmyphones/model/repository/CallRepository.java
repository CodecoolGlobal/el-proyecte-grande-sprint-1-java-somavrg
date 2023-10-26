package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CallRepository extends JpaRepository<Call,Long> {
    Set<Call> findCallsByDispatcherId(Long dispatcherId);
    Set<Call> getCallsByDispatcherIdAndCallStatus(Long dispatcherId,CallStatus callStatus);
}
