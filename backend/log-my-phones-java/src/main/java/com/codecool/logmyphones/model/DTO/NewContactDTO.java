package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.ClientPhone;
import lombok.Builder;


@Builder
public record NewContactDTO(String name,
        String clientPhone,
        String info,
        Long companyUserId) {}
