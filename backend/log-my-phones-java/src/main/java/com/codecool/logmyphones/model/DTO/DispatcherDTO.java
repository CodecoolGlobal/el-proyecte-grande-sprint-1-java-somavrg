package com.codecool.logmyphones.model.DTO;

import lombok.Builder;

import java.util.Set;
@Builder
public record DispatcherDTO(
        String name,
        String phoneNumber,
        Set<CallDTO> calls
){}
