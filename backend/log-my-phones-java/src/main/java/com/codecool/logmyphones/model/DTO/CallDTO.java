package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.CallDirection;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.ClientPhone;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record CallDTO(
        DispatcherDTO dispatcher,
        ClientPhone clientPhone,
        LocalDateTime startTime,
        CallStatus callStatus,
        CallDirection callDirection,
        int duration) {
}
