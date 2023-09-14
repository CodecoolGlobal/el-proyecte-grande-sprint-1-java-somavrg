package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.modell.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {

    // new arraylist maybe?
    private final List<Contact> contacts = List.of(new Contact(1, "James", "+36202567383"));


    @GetMapping("/")
    public List<Contact> getAllContacts() {

        //TODO: contactService.getContacts()

        return List.copyOf(contacts);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {

        //TODO: contactService.getContactById(id)

        // filter for contact with same id
        return contacts.get(id);
    }

    @PostMapping("/")
    public boolean addNewContact(@RequestBody Contact contact) {

        //TODO: contactService.addNewContact(contact)

        return contacts.add(contact);
    }


    //TODO: PatchMapping


    @DeleteMapping("/{id}/delete")
    public boolean deleteContactById(@PathVariable int id) {

        //TODO: contactService.deleteContactById(id)

        // filter for contact with same id
        return contacts.remove(contacts.get(id));
    }
}
