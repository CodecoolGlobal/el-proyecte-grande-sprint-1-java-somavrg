package com.codecool.logmyphones.model.DTO;

public record CallStatisticsResponse(
        int handledCalls,
        double averageCallTime,
        int failedCalls
) {
}
