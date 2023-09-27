package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.Phone;

import java.util.Set;

public record DispatcherDTO(
        String name,
        Phone phone,
        Set<CallDTO> callDTOS) {}
