package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.Call;
import com.codecool.logmyphones.model.ClientPhone;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.DTO.NewCallDTO;
import com.codecool.logmyphones.model.Dispatcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Mapper(componentModel = "spring")
public interface CallMapper {

    CallDTO toCallDTO(Call call);
    @Mapping(target = "id", ignore = true)
    Call toCall(NewCallDTO newCallDTO, Dispatcher dispatcher, ClientPhone clientPhone);
    List<CallDTO> toCallDTOs(List<Call> calls);
    Call toCall(CallDTO callDTO);
    Set<Call> toCalls(Set<CallDTO> callDTOs);

}
