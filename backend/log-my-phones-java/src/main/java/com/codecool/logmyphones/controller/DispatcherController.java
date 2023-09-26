package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.Dispatcher;

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
    public Set<Dispatcher> getAllDispatchersByCompany(@PathVariable int companyId) {
        //TODO: dispatcherService.getDispatchersByCompanyId(companyId)
        return null;
    }

    @GetMapping("/{companyId}/{id}")
    public Dispatcher getDispatcherById(@PathVariable int companyId, @PathVariable int id) {
        // TODO: dispatcherService.getDispatcherById(id)
        return null;
    }

    @PostMapping("/{companyId}")
    public boolean addNewDispatcher(@PathVariable int companyId, @RequestBody Dispatcher dispatcher) {
        // TODO: dispatcherService.addNewDispatcher(dispatcher)
        return false;
    }

    @PatchMapping("/{companyId}/{id}")
    public void updateDispatcherById(@PathVariable int companyId,
                                     @PathVariable int id,
                                     @RequestBody Dispatcher dispatcherUpdate) {
        // TODO: dispatcherService.updateDispatcher(id, dispatcherUpdate)
    }

    @DeleteMapping("/{companyId}/{id}")
    public boolean deleteDispatcher(@PathVariable int companyId, @PathVariable int id) {
        // TODO: dispatcherService.deleteDispatcherById(id)
        return false;
    }
}

