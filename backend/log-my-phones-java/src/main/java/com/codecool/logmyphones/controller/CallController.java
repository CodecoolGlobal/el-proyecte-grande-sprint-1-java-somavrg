package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.CallStatus;
import com.codecool.logmyphones.model.DTO.CallDTO;
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
    public Set<CallDTO> getAllCallsByCompany(@PathVariable Long companyId) {
        //TODO: callService.getCalls()
        return null;
    }

    @GetMapping("/{companyId}/byDispatchers")
    public Set<CallDTO> getAllCallsByDispatchers(@PathVariable Long companyId,
                                                 @RequestBody Set<Long> dispatcherIds) {
        //TODO: callService.getCallsByDispatchers()
        return null;
    }

    @GetMapping("/{companyId}/byStatus")
    public Set<CallDTO> getAllCallsByStatus(@PathVariable Long companyId, @RequestBody CallStatus callStatus) {
        //TODO: callService.getCallsByStatus(callStatus)
        return null;
    }
}
