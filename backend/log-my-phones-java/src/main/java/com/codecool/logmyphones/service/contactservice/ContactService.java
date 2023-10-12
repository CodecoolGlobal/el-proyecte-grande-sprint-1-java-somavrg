package com.codecool.logmyphones.service.contactservice;

import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.DTO.NewContactDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface ContactService {
    ResponseEntity<Set<ContactDTO>> getAllContacts(String token);
    ResponseEntity<ContactDTO> getContactById(Long id);
    ResponseEntity<NewContactDTO> addNewContact(NewContactDTO contactDTO);
    ResponseEntity<ContactDTO> updateContact(Long id, ContactDTO contactDTO);
    HttpStatus deleteContact(Long id);
}
