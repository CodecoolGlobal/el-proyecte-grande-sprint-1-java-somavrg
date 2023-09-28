package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.Contact;
import com.codecool.logmyphones.model.DTO.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = PhoneMapper.class, componentModel = "spring")
public interface ContactMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "info", target = "info")

    ContactDTO toContactDTO(Contact contact);
    Contact toContact(ContactDTO contactDTO);
}
