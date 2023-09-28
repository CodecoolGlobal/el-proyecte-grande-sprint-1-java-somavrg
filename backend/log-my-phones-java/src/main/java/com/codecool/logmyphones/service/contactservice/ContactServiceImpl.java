package com.codecool.logmyphones.service.contactservice;

import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public Set<ContactDTO> getAllContacts() {
        return contactRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public ContactDTO getContactById(Long id) {
        return contactRepository.getById(id);
    }

    @Override
    public void addNewContact(ContactDTO contactDTO) {
        contactRepository.save(contactDTO);
    }

    @Override
    public void updateContact(Long id, ContactDTO contactDTO) {

    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
