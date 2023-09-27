package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.Phone;
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
    public Phone getDispatcherById(@PathVariable int id) {
        // TODO: phoneService.getPhoneById(id)
        return null;
    }

    @PostMapping("")
    public boolean addNewPhone(@RequestBody Phone phone) {
        //TODO: phoneService.addNewPhone(phone)
        return false;
    }
}
