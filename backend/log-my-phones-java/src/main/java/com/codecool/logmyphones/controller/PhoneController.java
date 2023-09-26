
package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.Phone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    private final List<Phone> phones = new ArrayList<>(List.of(
            new Phone(1, "Ursula", "ursula@email.com"),
            new Phone(2, "Xavier", "xavier@email.com"),
            new Phone(3, "Victoria", "victoria@email.com"),
            new Phone(4, "Winston", "winston@email.com"),
            new Phone(5, "Yasmine", "yasmine@email.com"),
            new Phone(6, "Zachary", "zachary@email.com"),
            new Phone(7, "Alice", "alice@email.com"),
            new Phone(8, "Bryan", "bryan@email.com"),
            new Phone(9, "Catherine", "catherine@email.com"),
            new Phone(10, "David", "davidphn@email.com"),
            new Phone(11, "Ella", "ella@email.com"),
            new Phone(12, "Frank", "frank@email.com"),
            new Phone(13, "Grace", "gracephn@email.com"),
            new Phone(14, "Henry", "henryphn@email.com"),
            new Phone(15, "Isabella", "isabellaphn@email.com"),
            new Phone(16, "Jack", "jackphn@email.com"),
            new Phone(17, "Katherine", "katherinephn@email.com"),
            new Phone(18, "Liam", "liamphn@email.com"),
            new Phone(19, "Mia", "miaphn@email.com"),
            new Phone(20, "Noah", "noahphn@email.com"),
            new Phone(21, "Olivia", "oliviaphn@email.com")
    ));


    @GetMapping("/{companyId}")
    public List<Phone> getPhones(@PathVariable int companyId) {
        //TODO: phoneService.getPhonesByCompanyId(companyId)
        return new ArrayList<>(phones);
    }

    @GetMapping("/{id}")
    public Phone getPhoneById(@PathVariable int id) {
        // TODO: phoneService.getPhoneById(id)
        return phones.get(id);
    }

    @PostMapping("")
    public boolean addNewPhone(@RequestBody Phone phone) {
        // TODO: phoneService.addNewPhone(phone)
        return phones.add(phone);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Phone> patchPhone(@PathVariable int id, @RequestBody Phone phoneDetails) {
        // TODO: phoneService.patchPhone(id, phoneDetails)
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public boolean deletePhone(@PathVariable int id) {
        // TODO: phoneService.deletePhoneById(id)
        return phones.remove(phones.get(id));
    }
}

