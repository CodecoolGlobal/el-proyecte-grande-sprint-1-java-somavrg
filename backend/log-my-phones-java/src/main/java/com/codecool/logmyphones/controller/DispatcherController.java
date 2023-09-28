package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.DispatcherDTO;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dispatchers")
public class DispatcherController {

    //TODO service

    //    private final DispatcherService dispatcherService;
    //
    //    @Autowired
    //    public DispatcherController(DispatcherService dispatcherService) {
    //        this.dispatcherService = dispatcherService;
    //    }


    @GetMapping("/{companyId}")
    public Set<DispatcherDTO> getAllDispatchersByCompany(@PathVariable Long companyId) {
        //TODO: dispatcherService.getDispatchersByCompanyId(companyId)
        return null;
    }

    @GetMapping("/{companyId}/{id}")
    public DispatcherDTO getDispatcherById(@PathVariable Long companyId, @PathVariable Long id) {
        // TODO: dispatcherService.getDispatcherById(id)
        return null;
    }

    @PostMapping("/{companyId}")
    public void addNewDispatcher(@PathVariable Long companyId, @RequestBody DispatcherDTO dispatcher) {
        // TODO: dispatcherService.addNewDispatcher(dispatcher)
    }

    @PatchMapping("/{companyId}/{id}")
    public void updateDispatcherById(@PathVariable Long companyId,
                                     @PathVariable Long id,
                                     @RequestBody DispatcherDTO dispatcherUpdate) {
        // TODO: dispatcherService.updateDispatcher(id, dispatcherUpdate)
    }

    @DeleteMapping("/{companyId}/{id}")
    public void deleteDispatcher(@PathVariable Long companyId, @PathVariable Long id) {
        // TODO: dispatcherService.deleteDispatcherById(id)
    }
}

