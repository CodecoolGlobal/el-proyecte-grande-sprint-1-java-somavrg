package com.codecool.logmyphones.service.contactservice;

import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.repository.ContactRepository;
import com.codecool.logmyphones.service.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }


    @Override
    public Set<ContactDTO> getAllContacts(Long companyId) {
        return contactMapper.toContactDTOs(contactRepository.getContactsByUserUserId(companyId));
    }

    @Override
    public ContactDTO getContactById(Long id) {
        return contactMapper.toContactDTO(contactRepository.getById(id));
    }

    @Override
    public void addNewContact(ContactDTO contactDTO) {
        contactRepository.save(contactMapper.toContact(contactDTO));
    }

    @Override
    public void updateContact(Long id, ContactDTO contactDTO) {

    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
