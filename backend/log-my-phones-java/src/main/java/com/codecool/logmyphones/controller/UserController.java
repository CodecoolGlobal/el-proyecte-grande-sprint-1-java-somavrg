package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.CompanyUser;

import com.codecool.logmyphones.model.DTO.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
    public Set<UserDTO> getAllUsers() {
        //TODO: userService.getAllUsers()
        return null;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        //TODO: userService.getUserById(id)
        return null;
    }

    @PostMapping("")
    public boolean addNewUser(@RequestBody UserDTO user) {
        //TODO: userService.addNewUser(user)
        return false;
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO userUpdate) {
        //TODO: userService.updateUser(id, userUpdate)
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        //TODO: userService.deleteUserById(id)
        return false;
    }
}
