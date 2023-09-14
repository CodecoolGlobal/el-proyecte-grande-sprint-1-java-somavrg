
package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.modell.Phone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    private final List<Phone> phones = new ArrayList<>();

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

