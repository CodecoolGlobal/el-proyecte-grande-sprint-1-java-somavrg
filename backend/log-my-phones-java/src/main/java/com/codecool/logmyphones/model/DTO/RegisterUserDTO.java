package com.codecool.logmyphones.model.DTO;

import lombok.Builder;

@Builder
public record RegisterUserDTO (
        String name,
        String email,
        String password){}
