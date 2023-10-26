package com.codecool.logmyphones.controller;

import java.lang.String;
import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
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
    public List<CallDTO> getAllCallsByCompany(@RequestHeader("Authorization") String token) {
        return callService.getCalls(token);
    }

    // TODO api nevek vallalhatatlanok
    // TODO getbe nincs request body
    // TODO ossze kell vonni ezt a 2-t plusz page-eles
    @GetMapping("/byDispatchers")
    public ResponseEntity<List<CallDTO>> getAllCallsByDispatchers(@RequestBody Set<Long> dispatcherIds) {
        return callService.getCallsByDispatchers(dispatcherIds);
    }

    @GetMapping("/byStatus")
    public ResponseEntity<List<CallDTO>> getAllCallsByStatus(@RequestHeader("Authorization") String token, @RequestBody CallStatus callStatus) {
        return callService.getCallsByStatus(token, callStatus);
    }

    @PostMapping
    public CallDTO addNewCall(@RequestBody NewCallDTO newCallDTO){
        return callService.addNewCall(newCallDTO);
    }
 }
