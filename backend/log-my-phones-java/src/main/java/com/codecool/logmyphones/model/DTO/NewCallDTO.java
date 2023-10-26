package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.CallDirection;
import com.codecool.logmyphones.model.CallStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record NewCallDTO(
        String dispatcherPhoneNumber,
        String clientPhoneNumber,
        LocalDateTime startTime,
        CallStatus callStatus,
        CallDirection callDirection,
        int duration
) {
}

