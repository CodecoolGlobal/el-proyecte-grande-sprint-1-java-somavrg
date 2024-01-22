package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.ClientPhone;
import lombok.Builder;

@Builder
public record ContactDTO(
        String name,
        ClientPhone clientPhone,
        String info) {}
