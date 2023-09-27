package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.CompanyUser;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    //TODO service

    //    private final UserService userService;
    //
    //    @Autowired
    //    public UserController(UserService userService) {
    //        this.userService = userService;
    //    }


    @GetMapping("")
    public List<CompanyUser> getAllUsers() {
        //TODO: userService.getAllUsers()
        return null;
    }

    @GetMapping("/{id}")
    public CompanyUser getUserById(@PathVariable int id) {
        //TODO: userService.getUserById(id)
        return null;
    }

    @PostMapping("")
    public boolean addNewUser(@RequestBody CompanyUser user) {
        //TODO: userService.addNewUser(user)
        return false;
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody CompanyUser userUpdate) {
        //TODO: userService.updateUser(id, userUpdate)
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        //TODO: userService.deleteUserById(id)
        return false;
    }
}
