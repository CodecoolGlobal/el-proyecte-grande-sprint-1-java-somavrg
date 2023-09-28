package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.DTO.CallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(uses = PhoneMapper.class, componentModel = "spring")
public interface CallMapper {
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "callStatus", target = "callStatus")
    @Mapping(source = "callDirection", target = "callDirection")
    @Mapping(source = "duration", target = "duration")
    CallDTO toCallDTO(Call call);
    Set<CallDTO> toCallDTOs(Set<Call> calls);
    Call toCall(CallDTO callDTO);
    Set<Call> toCalls(Set<CallDTO> callDTOs);

}
