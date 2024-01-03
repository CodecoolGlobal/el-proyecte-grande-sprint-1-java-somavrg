package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.service.CallStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calls")
public class CallStatisticsController {

    private final CallStatisticsService callStatisticsService;

    public CallStatisticsController(CallStatisticsService callStatisticsService) {
        this.callStatisticsService = callStatisticsService;
    }
}
