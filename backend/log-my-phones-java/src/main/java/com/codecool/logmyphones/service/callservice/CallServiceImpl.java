package com.codecool.logmyphones.service.callservice;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DAO.CallDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CallServiceImpl implements CallService {
    private final CallDAO callDAO;
    @Autowired
    public CallServiceImpl(CallDAO callDAO) {
        this.callDAO = callDAO;
    }

    @Override
    public Set<Call> getCalls(Long companyId) {
        return null;
    }

    @Override
    public Set<Call> getCallsByDispatchers(Long companyId, Set<Long> dispatcherId) {
        return null;
    }

    @Override
    public Set<Call> getCallsByStatus(CallStatus callStatus) {
        return null;
    }
}
