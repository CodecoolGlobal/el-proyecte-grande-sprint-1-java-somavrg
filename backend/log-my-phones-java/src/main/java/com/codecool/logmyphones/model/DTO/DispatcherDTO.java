package com.codecool.logmyphones.model.DTO;

import lombok.Builder;

import java.util.Set;
@Builder
public record DispatcherDTO(
        String name,
        PhoneDTO phone,
        Set<CallDTO> calls) {}
