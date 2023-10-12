package com.codecool.logmyphones.controller;

import java.lang.String;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.service.callservice.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<Set<CallDTO>> getAllCallsByCompany(@RequestHeader("Authorization") String token) {
        return callService.getCalls(token);
    }

    @GetMapping("/byDispatchers")
    public ResponseEntity<Set<CallDTO>> getAllCallsByDispatchers(@RequestBody Set<Long> dispatcherIds) {
        return callService.getCallsByDispatchers(dispatcherIds);
    }

    @GetMapping("/byStatus")
    public ResponseEntity<Set<CallDTO>> getAllCallsByStatus(@RequestHeader("Authorization") String token, @RequestBody CallStatus callStatus) {
        return callService.getCallsByStatus(token, callStatus);
    }

    @PostMapping
    public ResponseEntity<CallDTO> addNewCall(@RequestBody CallDTO call){
        return callService.addNewCall(call);
    }
 }
