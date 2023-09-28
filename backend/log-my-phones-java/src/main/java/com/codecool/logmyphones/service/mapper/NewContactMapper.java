package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.Contact;
import com.codecool.logmyphones.model.DTO.NewContactDTO;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {PhoneMapper.class})
public interface NewContactMapper {
    @Mapping(source = "userUserId", target = "user.userId")
    Contact toContact(NewContactDTO newContactDTO);
    Set<Contact> toContact(Set<NewContactDTO> newContactDTO);

    @Mapping(source = "user.userId", target = "userUserId")
    NewContactDTO toContactDTO(Contact contact);
    Set<NewContactDTO> toContactDTO(Set<Contact> contact);
}
