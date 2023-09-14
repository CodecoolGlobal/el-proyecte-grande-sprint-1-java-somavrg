package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.modell.Call;
import com.codecool.logmyphones.modell.CallStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("calls")
public class CallController {

    private final List<Call> calls = new ArrayList<>(List.of(
            new Call(1, "+37311234567", "+37317654321", LocalDateTime.now(), CallStatus.FAILED, 0),
            new Call(2, "+37311234570", "+37317654324", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(3, "+37311234571", "+37317654325", LocalDateTime.now(), CallStatus.FAILED, 0),
            new Call(4, "+37311234572", "+37317654326", LocalDateTime.now(), CallStatus.SUCCESSFUL, 12345),
            new Call(5, "+37311234573", "+37317654327", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(6, "+37311234574", "+37317654328", LocalDateTime.now(), CallStatus.SUCCESSFUL, 56789),
            new Call(7, "+37311234575", "+37317654329", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(8, "+37311234576", "+37317654330", LocalDateTime.now(), CallStatus.FAILED, 0),
            new Call(9, "+37311234577", "+37317654331", LocalDateTime.now(), CallStatus.SUCCESSFUL, 98765),
            new Call(10, "+37311234578", "+37317654332", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(11, "+37311234579", "+37317654333", LocalDateTime.now(), CallStatus.FAILED, 0),
            new Call(12, "+37311234580", "+37317654334", LocalDateTime.now(), CallStatus.SUCCESSFUL, 54321),
            new Call(13, "+37311234581", "+37317654335", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(14, "+37311234582", "+37317654336", LocalDateTime.now(), CallStatus.SUCCESSFUL, 23456),
            new Call(15, "+37311234583", "+37317654337", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(16, "+37311234584", "+37317654338", LocalDateTime.now(), CallStatus.FAILED, 0),
            new Call(17, "+37311234585", "+37317654339", LocalDateTime.now(), CallStatus.SUCCESSFUL, 87654),
            new Call(18, "+37311234586", "+37317654340", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(19, "+37311234568", "+37317654322", LocalDateTime.now(), CallStatus.ONGOING, 0),
            new Call(20, "+37311234569", "+37317654323", LocalDateTime.now(), CallStatus.SUCCESSFUL, 11234)
    ));

    @GetMapping("/")
    public List<Call> getAllCalls() {

        //TODO: callService.getCalls()

        return new ArrayList<>(calls);
    }

    @GetMapping("/{id}")
    public Call getCallById(@PathVariable int id) {

        //TODO: callService.getCallById(id)

        // filter for call with same id
        return calls.get(id);
    }
}
