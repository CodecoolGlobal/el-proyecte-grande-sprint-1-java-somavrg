package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.ContactDTO;
import com.codecool.logmyphones.model.DTO.NewContactDTO;
import com.codecool.logmyphones.service.contactservice.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{companyId}")
    public Set<ContactDTO> getAllContactsByCompany(@PathVariable Long companyId) {
        return contactService.getAllContacts(companyId);
    }

    @GetMapping("/contact/{id}")
    public ContactDTO getContactById( @PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    public void addNewContact(@RequestBody NewContactDTO contact) {
        contactService.addNewContact(contact);
    }

    @PatchMapping("/contact/{id}")
    public void updateContactById(@PathVariable Long id,
                                  @RequestBody ContactDTO contactUpdate) {
        contactService.updateContact(id, contactUpdate);
    }

    @DeleteMapping("/contact/{id}")
    public void deleteContactById(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
