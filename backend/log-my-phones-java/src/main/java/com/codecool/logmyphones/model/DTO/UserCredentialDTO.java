package com.codecool.logmyphones.model.DTO;

import lombok.Builder;

@Builder
public record UserCredentialDTO(
        String name,
        String email,
        String password){}


