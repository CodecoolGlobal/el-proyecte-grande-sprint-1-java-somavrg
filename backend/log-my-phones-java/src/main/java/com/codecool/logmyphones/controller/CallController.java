package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.service.callservice.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/calls")
public class CallController {
    private final CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping("/{companyId}")
    public Set<CallDTO> getAllCallsByCompany(@PathVariable Long companyId) {
        return callService.getCalls(companyId);
    }

    @GetMapping("/{companyId}/byDispatchers")
    public Set<CallDTO> getAllCallsByDispatchers(@PathVariable Long companyId,
                                                 @RequestBody Set<Long> dispatcherIds) {
        return callService.getCallsByDispatchers(companyId, dispatcherIds);
    }

    @GetMapping("/{companyId}/byStatus")
    public Set<CallDTO> getAllCallsByStatus(@PathVariable Long companyId, @RequestBody CallStatus callStatus) {
        return callService.getCallsByStatus(companyId, callStatus);
    }

    @PostMapping
    public void addNewCall(@RequestBody CallDTO call){
        callService.addNewCall(call);
    }
 }
