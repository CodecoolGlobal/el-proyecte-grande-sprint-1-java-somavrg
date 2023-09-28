package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.DTO.CallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = PhoneMapper.class, componentModel = "spring")
public interface CallMapper {
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "callStatus", target = "callStatus")
    @Mapping(source = "callDirection", target = "callDirection")
    @Mapping(source = "duration", target = "duration")
    CallDTO toCall(Call call);
    Call toCallDTO(CallDTO callDTO);

}
