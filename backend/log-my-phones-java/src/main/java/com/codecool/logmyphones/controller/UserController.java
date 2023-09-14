package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.modell.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final List<User> users = new ArrayList<>();

    @GetMapping("")
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        //TODO: userService.getUserById(id)
        return users.get(id);
    }

    @PostMapping("")
    public boolean addNewUser(@RequestBody User user) {
        //TODO: userService.addNewUser(user)
        return false;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable int id, @RequestBody User userDetails) {
        //TODO: userService.patchUser(id,userDetails)
        return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        //TODO: userService.deleteUserById(id)
        return false;
    }
}
