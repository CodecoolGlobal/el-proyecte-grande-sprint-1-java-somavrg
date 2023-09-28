package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.UserDTO;
import com.codecool.logmyphones.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public Set<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("")
    public void addNewUser(@RequestBody UserDTO user) {
        userService.addNewUser(user);
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO userUpdate) {
        userService.updateUser(id, userUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
