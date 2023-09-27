package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.Phone;
import lombok.Builder;

import java.util.Set;
@Builder
public record DispatcherDTO(
        String name,
        Phone phone,
        Set<CallDTO> callDTOS) {}
