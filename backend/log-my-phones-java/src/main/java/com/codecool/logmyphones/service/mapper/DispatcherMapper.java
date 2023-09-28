package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.Dispatcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(uses = {PhoneMapper.class, CallMapper.class}, componentModel = "spring")
public interface DispatcherMapper {
    @Mapping(source = "name", target = "name")
    DispatcherDTO toDispatcherDTO(Dispatcher dispatcher);
    Set<DispatcherDTO> toDispatcherDTOs(Set<Dispatcher> dispatchers);
    Dispatcher toDispatcher(DispatcherDTO dispatcher);
    Set<Dispatcher> toDispatchers(Set<DispatcherDTO> dispatchers);
}
