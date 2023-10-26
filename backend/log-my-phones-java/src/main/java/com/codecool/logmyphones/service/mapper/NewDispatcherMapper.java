package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;
import com.codecool.logmyphones.model.Dispatcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ClientPhoneMapper.class})
public interface NewDispatcherMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "newDispatcherDTO.name")
    Dispatcher toDispatcher(NewDispatcherDTO newDispatcherDTO, CompanyUser user);
    Set<Dispatcher> toDispatchers(Set<NewDispatcherDTO> newDispatcherDTOS);
    NewDispatcherDTO toDispatcherDTO(Dispatcher dispatcher);
    Set<NewDispatcherDTO> toCDispatcherDTOs(Set<Dispatcher> dispatchers);
}
