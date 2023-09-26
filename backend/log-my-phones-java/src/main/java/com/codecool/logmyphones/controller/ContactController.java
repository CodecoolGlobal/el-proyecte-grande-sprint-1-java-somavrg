package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.Contact;
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
    public Set<Contact> getAllContactsByCompany(@PathVariable int companyId) {
        //TODO: contactService.getContacts()
        return null;
    }

    @GetMapping("/{companyId}/{id}")
    public Contact getContactById(@PathVariable int companyId, int id) {
        //TODO: contactService.getContactById(id)
        return null;
    }

    @PostMapping("/{companyId}")
    public boolean addNewContact(@PathVariable("companyId") int companyId, @RequestBody Contact contact) {
        //TODO: contactService.addNewContact(contact)
        return false;
    }

    @PutMapping("/{companyId}/{id}")
    public void updateContactById(@PathVariable("companyId") int companyId,
                                  @PathVariable("id") int id,
                                  @RequestBody Contact contactUpdate) {
        //TODO: contactService.updateRoomById(id, contactUpdate);
    }

    @DeleteMapping("/{companyId}/{id}/delete")
    public boolean deleteContactById(@PathVariable("companyId") int companyId, @PathVariable int id) {
        //TODO: contactService.deleteContactById(id)
        return false;
    }
}
