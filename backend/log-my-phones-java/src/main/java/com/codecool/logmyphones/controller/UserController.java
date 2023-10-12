package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.DTO.UserDTO;
import com.codecool.logmyphones.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUserById(@RequestHeader("Authorization") String token) {
        return userService.getUserById(token);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO user) {
        return userService.addNewUser(user);
    }

    @PatchMapping
    public ResponseEntity<UserDTO> updateUser(@RequestHeader("Authorization") String token, @RequestBody UserDTO userUpdate) {
       return userService.updateUser(token, userUpdate);
    }

    @DeleteMapping
    public HttpStatus deleteUser(@RequestHeader("Authorization") String token) {
        return userService.deleteUser(token);
    }
}
