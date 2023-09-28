package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.Phone;
import lombok.Builder;


@Builder
public record NewContactDTO(String name,
        Phone phone,
        String info,
        Long userUserId) {}
