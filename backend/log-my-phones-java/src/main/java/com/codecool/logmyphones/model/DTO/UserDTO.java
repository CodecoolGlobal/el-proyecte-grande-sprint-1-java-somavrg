package com.codecool.logmyphones.model.DTO;

import com.codecool.logmyphones.model.Dispatcher;

import java.util.Set;

public record UserDTO(String name,
                      String email,
                      Set<ContactDTO> contactDTOs,
                      Set<Dispatcher> dispatchers) {}
