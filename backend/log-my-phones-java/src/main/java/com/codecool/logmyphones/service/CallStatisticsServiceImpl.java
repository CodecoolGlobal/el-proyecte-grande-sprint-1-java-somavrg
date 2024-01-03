package com.codecool.logmyphones.service;

import com.codecool.logmyphones.model.DTO.CallStatisticsResponse;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.repository.CallRepository;
import com.codecool.logmyphones.model.repository.DispatcherRepository;
import com.codecool.logmyphones.security.JwtService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CallStatisticsServiceImpl implements CallStatisticsService {

    private final CallRepository callRepository;
    private final JwtService jwtService;
    private final DispatcherRepository dispatcherRepository;

    public CallStatisticsServiceImpl(CallRepository callRepository, JwtService jwtService, DispatcherRepository dispatcherRepository) {
        this.callRepository = callRepository;
        this.jwtService = jwtService;
        this.dispatcherRepository = dispatcherRepository;
    }

    @Override
    public CallStatisticsResponse getCallStatistics(String token) {
        String userEmail = jwtService.extractUsername(token.split(" ")[1]);
        Set<Long> dispatcherIds = dispatcherRepository.findByUser_Email(userEmail).stream()
                .map(Dispatcher::getId).collect(Collectors.toSet());

        return new CallStatisticsResponse(
                callRepository.countCallsByDispatcherIdIn(dispatcherIds),
                callRepository.getAverageCallTimeByDispatcherIdIn(dispatcherIds),
                callRepository.countFailedCallsByDispatcherIdIn(dispatcherIds)
        );
    }
}
