package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.Phone;
import lombok.Builder;

@Builder
public record ContactDTO(
        String name,
        Phone phone,
        String info) {}
