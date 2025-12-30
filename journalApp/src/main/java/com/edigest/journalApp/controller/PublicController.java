package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    // Public health check endpoint - no authentication required
    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Application is running", HttpStatus.OK);
    }

    // Public welcome endpoint
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("Welcome to Journal App", HttpStatus.OK);
    }

    // Public endpoint to create new user - no authentication required
    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Set default role for new users
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Arrays.asList("ROLE_USER"));
        }
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}

