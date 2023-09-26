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
    private final List<User> users = new ArrayList<>(List.of(
            new User(1, "Jamie", "jamie@email.com"),
            new User(2, "Johnathan", "johnathan@email.com"),
            new User(3, "Marie", "marie@email.com"),
            new User(4, "Daniel", "daniel@email.com"),
            new User(5, "Samantha", "samantha@email.com"),
            new User(6, "Michaela", "michaela@email.com"),
            new User(7, "Emilia", "emilia@email.com"),
            new User(8, "William", "william@email.com"),
            new User(9, "Oliver", "oliver@email.com"),
            new User(10, "Danielle", "danielle@email.com"),
            new User(11, "Sophie", "sophie@email.com"),
            new User(12, "Matthew", "matthew@email.com"),
            new User(13, "Ava", "ava@email.com"),
            new User(14, "Chris", "chris@email.com"),
            new User(15, "Emma", "emma@email.com"),
            new User(16, "Josephine", "josephine@email.com"),
            new User(17, "Charlie", "charlie@email.com"),
            new User(18, "Benjamin", "benjamin@email.com"),
            new User(19, "Mia", "mia@email.com"),
            new User(20, "Alex", "alex@email.com"),
            new User(21, "Grace", "grace@email.com")
    ));


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
        return users.add(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable int id, @RequestBody User userDetails) {
        //TODO: userService.patchUser(id,userDetails)
        return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        //TODO: userService.deleteUserById(id)
        return users.remove(users.get(id));
    }
}
