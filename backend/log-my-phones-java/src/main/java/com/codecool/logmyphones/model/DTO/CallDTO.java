package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.CallDirection;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.Dispatcher;
import com.codecool.logmyphones.model.Phone;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record CallDTO(
        Dispatcher dispatcher,
        Phone client,
        LocalDateTime startTime,
        CallStatus callStatus,
        CallDirection callDirection,
        int duration) {
}
