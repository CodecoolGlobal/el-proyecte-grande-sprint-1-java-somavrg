package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.Contact;
import com.codecool.logmyphones.model.DTO.NewContactDTO;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {ClientPhoneMapper.class})
public interface NewContactMapper {
    Contact toContact(NewContactDTO newContactDTO);
    Set<Contact> toContact(Set<NewContactDTO> newContactDTO);
    NewContactDTO toContactDTO(Contact contact);
    Set<NewContactDTO> toContactDTO(Set<Contact> contact);
}
