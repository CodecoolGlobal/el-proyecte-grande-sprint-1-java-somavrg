package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CallRepository extends JpaRepository<Call,Long> {
    Set<Call> getCallsByDispatcherDispatcherId(Long dispatcherId);
    Set<Call> getCallsByDispatcherDispatcherIdAndCallStatus(Long dispatcherId,CallStatus callStatus);
}
