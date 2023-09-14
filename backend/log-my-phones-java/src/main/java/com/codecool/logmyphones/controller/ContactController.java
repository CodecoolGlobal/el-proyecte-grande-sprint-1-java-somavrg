package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.modell.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final List<Contact> contacts = new ArrayList<>(Arrays.asList(
            new Contact(1, "James", "+36202567383"),
            new Contact(2, "John", "+36204567890"),
            new Contact(3, "Mary", "+36201234567"),
            new Contact(4, "David", "+36203456789"),
            new Contact(5, "Sarah", "+36207654321"),
            new Contact(6, "Michael", "+36201122334"),
            new Contact(7, "Emily", "+36209876543"),
            new Contact(8, "William", "+36205678901"),
            new Contact(9, "Olivia", "+36204567890"),
            new Contact(10, "Daniel", "+36201234567"),
            new Contact(11, "Sophia", "+36203456789"),
            new Contact(12, "Matthew", "+36207654321"),
            new Contact(13, "Ava", "+36201122334"),
            new Contact(14, "Christopher", "+36209876543"),
            new Contact(15, "Emma", "+36205678901"),
            new Contact(16, "Joseph", "+36204567890"),
            new Contact(17, "Chloe", "+36201234567"),
            new Contact(18, "Benjamin", "+36203456789"),
            new Contact(19, "Mia", "+36207654321"),
            new Contact(20, "Alexander", "+36201122334"),
            new Contact(21, "Grace", "+36209876543")
    ));


    @GetMapping("")
    public List<Contact> getAllContacts() {

        //TODO: contactService.getContacts()

        return new ArrayList<>(contacts);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {

        //TODO: contactService.getContactById(id)

        // filter for contact with same id
        return contacts.get(id);
    }

    @PostMapping("")
    public boolean addNewContact(@RequestBody Contact contact) {

        //TODO: contactService.addNewContact(contact)
        Contact newContact = new Contact(contacts.size() + 1, contact.name(), contact.phoneNumber());
        return contacts.add(newContact);
    }


    //TODO: PatchMapping


    @DeleteMapping("/{id}/delete")
    public boolean deleteContactById(@PathVariable int id) {

        //TODO: contactService.deleteContactById(id)

        // filter for contact with same id
        return contacts.remove(contacts.get(id));
    }
}
