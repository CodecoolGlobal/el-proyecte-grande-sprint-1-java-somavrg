package com.codecool.logmyphones.model.DTO;

import lombok.Builder;

@Builder
public record ContactDTO(
        String name,
        PhoneDTO phone,
        String info) {}
