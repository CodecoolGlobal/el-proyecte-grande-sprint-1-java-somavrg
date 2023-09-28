package com.codecool.logmyphones.service.contactservice;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.Contact;
import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.DTO.NewContactDTO;
import com.codecool.logmyphones.model.repository.ContactRepository;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.service.mapper.ContactMapper;
import com.codecool.logmyphones.service.mapper.NewContactMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public Set<ContactDTO> getAllContacts(Long companyId) {
        return contactMapper.toContactDTOs(contactRepository.getContactsByUserUserId(companyId));
    }

    @Override
    public ContactDTO getContactById(Long id) {
        return contactMapper.toContactDTO(contactRepository.getById(id));
    }

    @Override
    public void addNewContact(NewContactDTO contactDTO) {
        CompanyUser user = userRepository.getById(contactDTO.userUserId());
        Contact newContact = newContactMapper.toContact(contactDTO);
//        user.addContact(newContact);
        newContact.setUser(user);
        contactRepository.save(newContact);
    }

    @Override
    public void updateContact(Long id, ContactDTO contactDTO) {

    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
