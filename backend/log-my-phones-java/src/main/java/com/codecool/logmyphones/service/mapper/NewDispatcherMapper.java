package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.DTO.NewDispatcherDTO;
import com.codecool.logmyphones.model.Dispatcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {PhoneMapper.class})
public interface NewDispatcherMapper {
    @Mapping(source = "userUserId", target = "user.userId")
    Dispatcher toDispatcher(NewDispatcherDTO newDispatcherDTO);
    Set<Dispatcher> toDispatchers(Set<NewDispatcherDTO> newDispatcherDTOS);

    @Mapping(source = "user.userId", target = "userUserId")
    NewDispatcherDTO toDispatcherDTO(Dispatcher dispatcher);
    Set<NewDispatcherDTO> toCDispatcherDTOs(Set<Dispatcher> dispatchers);
}
