package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.PhoneDTO;
import com.codecool.logmyphones.service.phoneservice.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("")
    public void addNewPhone(@RequestBody PhoneDTO phone) {
        phoneService.addNewPhone(phone);
    }
}
