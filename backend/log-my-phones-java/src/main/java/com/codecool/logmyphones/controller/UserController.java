package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserDTO;
import com.codecool.logmyphones.security.JwtService;
import com.codecool.logmyphones.service.mapper.UserMapper;
import com.codecool.logmyphones.service.userservice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    private final JwtService jwtService;

    public UserController(UserService userService, UserMapper userMapper, JwtService jwtService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO user) {
        return userService.addNewUser(user);
    }


    @GetMapping("/me")
    public ResponseEntity<UserDTO> getAuthenticatedUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDTO userDTO = userService.getUserByEmail(email);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
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
