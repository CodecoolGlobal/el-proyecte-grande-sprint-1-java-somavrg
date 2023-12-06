package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.CallDirection;
import com.codecool.logmyphones.model.CallStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

public record NewCallDTO(
        @NonNull
        String dispatcherPhoneNumber,
        @NonNull
        String clientPhoneNumber,
        @NonNull
        LocalDateTime startTime,
        @NonNull
        CallStatus callStatus,
        @NonNull
        CallDirection callDirection,
        int duration
) {
}

