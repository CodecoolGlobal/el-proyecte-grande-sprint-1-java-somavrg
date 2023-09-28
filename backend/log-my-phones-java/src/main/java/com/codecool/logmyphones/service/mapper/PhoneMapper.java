package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.DTO.PhoneDTO;
import com.codecool.logmyphones.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    PhoneDTO toPhoneDTO(Phone phone);
    Phone toPhone(PhoneDTO phoneDTO);
}
