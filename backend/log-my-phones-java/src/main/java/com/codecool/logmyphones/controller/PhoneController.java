package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.PhoneDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    //TODO service

    //    private final PhoneService phoneService;
    //
    //    @Autowired
    //    public PhoneController(PhoneService phoneService) {
    //        this.phoneService = phoneService;
    //    }


    @GetMapping("/{id}")
    public PhoneDTO getDispatcherById(@PathVariable Long id) {
        // TODO: phoneService.getPhoneById(id)
        return null;
    }

    @PostMapping("")
    public void addNewPhone(@RequestBody PhoneDTO phone) {
        //TODO: phoneService.addNewPhone(phone)
    }
}
