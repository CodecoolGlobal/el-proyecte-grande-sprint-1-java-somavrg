package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;
import com.codecool.logmyphones.model.Dispatcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {PhoneMapper.class, CallMapper.class}, componentModel = "spring")
public interface DispatcherMapper {
    @Mapping(source = "name", target = "name")
    DispatcherDTO toDispatcherDTO(Dispatcher dispatcher);
    Dispatcher toDispatcher(DispatcherDTO dispatcher);
}
