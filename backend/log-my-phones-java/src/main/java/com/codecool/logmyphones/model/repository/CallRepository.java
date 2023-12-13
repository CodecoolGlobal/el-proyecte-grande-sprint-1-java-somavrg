package com.codecool.logmyphones.model.repository;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallDirection;
import com.codecool.logmyphones.model.CallStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Set;

public interface CallRepository extends JpaRepository<Call,Long> {
    Set<Call> findCallsByDispatcherId(Long dispatcherId);
    Page<Call> findCallsByDispatcherIdIn(Collection<Long> dispatcherIds, Pageable pageable);
    Page<Call> findCallsByDispatcherIdInAndCallDirection(Collection<Long> dispatcherIds,
                                                         CallDirection callDirection,
                                                         Pageable pageable);
    Set<Call> getCallsByDispatcherIdAndCallStatus(Long dispatcherId,CallStatus callStatus);
}
