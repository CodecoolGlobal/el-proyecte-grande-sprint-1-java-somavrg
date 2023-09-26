package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.Call;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/calls")
public class CallController {

    //TODO service

    //    private final CallService callService;
    //
    //    @Autowired
    //    public CallController(CallService callService) {
    //        this.callService = callService;
    //    }


    @GetMapping("/{companyId}")
    public Set<Call> getAllCallsByCompany(@PathVariable("companyId") int companyId) {
        //TODO: callService.getCalls()
        return null;
    }

    @GetMapping("/{companyId}/byDispatchers")
    public Set<Call> getAllCallsByDispatchers(@PathVariable("companyId") int companyId, @RequestBody Set<Integer> dispatcherIds) {
        //TODO: callService.getCallsByDispatchers()
        return null;
    }
}
