package com.example.phoenixcodecrafter.controller;

import com.example.phoenixcodecrafter.exception.UserNotFoundException;
import com.example.phoenixcodecrafter.model.User;
import com.example.phoenixcodecrafter.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> user = userService.getAllUser();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")Integer id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public List<User> createUser(@Valid @RequestBody List<@Valid User> users)
    {
        return userService.createUser(users);
    }

    @GetMapping("/email")
    public ResponseEntity<List<User>> getUserByEmail(@RequestParam String email) {

        List<User> users = userService.getUserByEmail(email);

        if (users.isEmpty()) {
            throw new UserNotFoundException("User not found with email: " + email);
        }
        return ResponseEntity.ok(users);
    }


}

