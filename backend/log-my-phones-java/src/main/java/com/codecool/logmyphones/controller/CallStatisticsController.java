package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.CallStatisticsResponse;
import com.codecool.logmyphones.service.CallStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics/calls")
public class CallStatisticsController {

    private final CallStatisticsService callStatisticsService;

    public CallStatisticsController(CallStatisticsService callStatisticsService) {
        this.callStatisticsService = callStatisticsService;
    }

    @GetMapping
    public CallStatisticsResponse getCallStatistics(@RequestHeader("Authorization") String token) {
        return callStatisticsService.getCallStatistics(token);
    }
}
