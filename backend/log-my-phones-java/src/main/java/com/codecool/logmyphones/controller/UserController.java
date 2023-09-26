package com.codecool.logmyphones.controller;

import com.codecool.logmyphones.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<User> getAllUsers() {
        //TODO: userService.getAllUsers()
        return null;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        //TODO: userService.getUserById(id)
        return null;
    }

    @PostMapping("")
    public boolean addNewUser(@RequestBody User user) {
        //TODO: userService.addNewUser(user)
        return false;
    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User userUpdate) {
        //TODO: userService.updateUser(id, userUpdate)
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        //TODO: userService.deleteUserById(id)
        return false;
    }
}
