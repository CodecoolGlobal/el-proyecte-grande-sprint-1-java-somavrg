package com.codecool.logmyphones.controller;

import java.lang.String;

import com.codecool.logmyphones.model.CallDirection;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
import com.codecool.logmyphones.model.DTO.CallResponse;
import com.codecool.logmyphones.model.DTO.NewCallDTO;
import com.codecool.logmyphones.service.callservice.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/calls")
public class CallController {
    private final CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping
    public CallResponse getAllCallsByCompany(
            @RequestHeader("Authorization") String token,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value= "callDirection", required = false) CallDirection callDirection
            ) {
        return callService.getCalls(token, pageNo, pageSize, callDirection);
    }

    @PostMapping
    public CallDTO addNewCall(@RequestBody NewCallDTO newCallDTO){
        return callService.addNewCall(newCallDTO);
    }
 }
