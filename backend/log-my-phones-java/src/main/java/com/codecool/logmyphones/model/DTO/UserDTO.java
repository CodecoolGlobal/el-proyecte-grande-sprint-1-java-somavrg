package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.Dispatcher;
import lombok.Builder;

import java.util.Set;
@Builder
public record UserDTO(String name,
                      String email,
                      Set<ContactDTO> contactDTOs,
                      Set<Dispatcher> dispatchers) {}
