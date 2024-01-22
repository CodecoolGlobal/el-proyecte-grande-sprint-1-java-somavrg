package com.codecool.logmyphones.service.contactservice;

import com.codecool.logmyphones.model.ClientPhone;
import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.Contact;
import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.DTO.NewContactDTO;
import com.codecool.logmyphones.model.repository.ClientPhoneRepository;
import com.codecool.logmyphones.model.repository.ContactRepository;
import com.codecool.logmyphones.model.repository.UserRepository;
import com.codecool.logmyphones.security.JwtService;
import com.codecool.logmyphones.service.mapper.ContactMapper;
import com.codecool.logmyphones.service.mapper.NewContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final ClientPhoneRepository clientPhoneRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper, UserRepository userRepository, JwtService jwtService, ClientPhoneRepository clientPhoneRepository) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.clientPhoneRepository = clientPhoneRepository;
    }

    @Override
    public ResponseEntity<Set<ContactDTO>> getAllContacts(String token) {
        Set<Contact> contactsByUserEmail = contactRepository.getContactsByUser_Email(jwtService.extractUsername(token.split(" ")[1]));
        System.out.println("---------------------------------------------- " + contactsByUserEmail);
        return new ResponseEntity<>(contactMapper.toContactDTOs(contactsByUserEmail),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContactDTO> getContactById(Long id) {
        return new ResponseEntity<>(contactMapper.toContactDTO(contactRepository.getById(id)), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<NewContactDTO> addNewContact(NewContactDTO contactDTO) {
        CompanyUser user = userRepository.getById(contactDTO.companyUserId());

        ClientPhone newClientPhone = clientPhoneRepository.findByPhoneNumber(contactDTO.clientPhone()).orElseGet(
                () -> clientPhoneRepository.save(createNewClientPhone(contactDTO.clientPhone()))
        );

        Contact newContact = new Contact();
        newContact.setName(contactDTO.name());
        newContact.setInfo(contactDTO.info());
        newContact.setClientPhone(newClientPhone);
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
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    private ClientPhone createNewClientPhone(String clientPhoneNumber){
        return ClientPhone.builder()
                .phoneNumber(clientPhoneNumber)
                .build();
    }
}
