package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.ClientPhone;
import com.codecool.logmyphones.model.DTO.PhoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ClientPhoneMapper {
    PhoneDTO toPhoneDTO(ClientPhone clientPhone);
    Set<PhoneDTO> toPhoneDTOs(Set<ClientPhone> clientPhone);
    ClientPhone toPhone(PhoneDTO phoneDTO);
    Set<ClientPhone> toPhones(Set<PhoneDTO> phoneDTO);
}
