package com.example.demo.controllers;

import com.example.demo.service.UserService;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userSevice;


    @GetMapping("/user/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<User>> getallUser() {

        return userSevice.findallUser();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserbyName(@PathVariable String username) {

        return userSevice.findbyName(username);
    }

    @PostMapping(value = "/user/save", consumes = "Application/json")
    public ResponseEntity<List<User>> saveUsers(@RequestBody List<User> users) {
        return userSevice.saveUsers(users);
    }

}


