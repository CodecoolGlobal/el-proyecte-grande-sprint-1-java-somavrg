package com.codecool.logmyphones.model.DTO;

import lombok.Builder;

@Builder
public record NewDispatcherDTO(
        String name,
        String phoneNumber,
        Long userId
) {}

