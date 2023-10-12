package com.codecool.logmyphones.service.contactservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.Contact;
import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.DTO.NewContactDTO;
import com.codecool.logmyphones.model.repository.ContactRepository;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.service.mapper.ContactMapper;
import com.codecool.logmyphones.service.mapper.NewContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final NewContactMapper newContactMapper;
    private final UserRepository userRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper, NewContactMapper newContactMapper, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
        this.newContactMapper = newContactMapper;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Set<ContactDTO>> getAllContacts(Long companyId) {
        return new ResponseEntity<>(contactMapper.toContactDTOs(contactRepository.getContactsByUserUserId(companyId)),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContactDTO> getContactById(Long id) {
        return new ResponseEntity<>(contactMapper.toContactDTO(contactRepository.getById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewContactDTO> addNewContact(NewContactDTO contactDTO) {
        CompanyUser user = userRepository.getById(contactDTO.userUserId());
        Contact newContact = newContactMapper.toContact(contactDTO);
        newContact.setUser(user);
        contactRepository.save(newContact);
        return new ResponseEntity<>(contactDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContactDTO> updateContact(Long id, ContactDTO contactDTO) {
        //TODO
        return null;
    }

    @Override
    public HttpStatus deleteContact(Long id) {
        contactRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
