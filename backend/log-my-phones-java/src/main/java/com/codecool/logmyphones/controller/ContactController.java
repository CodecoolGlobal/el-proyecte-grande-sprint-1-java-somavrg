package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.ContactDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    //TODO service

    //    private final ContactService contactService;
    //
    //    @Autowired
    //    public ContactController(ContactService contactService) {
    //        this.contactService = contactService;
    //    }


    @GetMapping("/{companyId}")
    public Set<ContactDTO> getAllContactsByCompany(@PathVariable Long companyId) {
        //TODO: contactService.getContacts()
        return null;
    }

    @GetMapping("/{companyId}/{id}")
    public ContactDTO getContactById(@PathVariable Long companyId, @PathVariable Long id) {
        //TODO: contactService.getContactById(id)
        return null;
    }

    @PostMapping("/{companyId}")
    public void addNewContact(@PathVariable Long companyId, @RequestBody ContactDTO contact) {
        //TODO: contactService.addNewContact(contact)
    }

    @PatchMapping("/{companyId}/{id}")
    public void updateContactById(@PathVariable Long companyId,
                                  @PathVariable Long id,
                                  @RequestBody ContactDTO contactUpdate) {
        //TODO: contactService.updateRoomById(id, contactUpdate);
    }

    @DeleteMapping("/{companyId}/{id}/delete")
    public void deleteContactById(@PathVariable Long companyId, @PathVariable Long id) {
        //TODO: contactService.deleteContactById(id)
    }
}
