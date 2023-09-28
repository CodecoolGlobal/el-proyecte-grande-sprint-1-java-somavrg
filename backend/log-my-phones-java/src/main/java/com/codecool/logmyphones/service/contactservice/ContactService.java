package com.codecool.logmyphones.service.contactservice;

import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.DTO.NewContactDTO;

import java.util.Set;

public interface ContactService {
    Set<ContactDTO> getAllContacts(Long companyId);
    ContactDTO getContactById(Long id);
    void addNewContact(NewContactDTO contactDTO);
    void updateContact(Long id, ContactDTO contactDTO);
    void deleteContact(Long id);
}
