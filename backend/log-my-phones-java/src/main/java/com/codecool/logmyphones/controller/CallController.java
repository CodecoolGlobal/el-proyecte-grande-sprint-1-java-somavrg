package com.codecool.logmyphones.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("calls")
public class CallController {
    private final List<String> calls = new ArrayList<>();
    @GetMapping("/")
    public List<String> getAllCalls() {

        //TODO: callService.getCalls()

        return new ArrayList<>(calls);
    }

    @GetMapping("/{id}")
    public String getCallById(@PathVariable int id) {

        //TODO: callService.getCallById(id)

        // filter for call with same id
        return calls.get(id);
    }
}
