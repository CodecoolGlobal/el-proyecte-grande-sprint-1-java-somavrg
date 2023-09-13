package com.codecool.logmyphones.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {
    /*private final List<Contact> contacts = List.of();*/
    private final List<String> contacts = new ArrayList<>();

    @GetMapping("/")
    public List<String> getAllContacts() {

        //TODO: contactService.getContacts()

        return new ArrayList<>(contacts);
    }

    @GetMapping("/{id}")
    public String getContactById(@PathVariable int id) {

        //TODO: contactService.getContactById(id)

        // filter for contact with same id
        return contacts.get(id);
    }

    @PostMapping("/")
    public boolean addNewContact(@RequestBody /*Contact contact*/ String contact) {

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
