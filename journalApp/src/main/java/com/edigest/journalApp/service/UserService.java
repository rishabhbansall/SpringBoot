package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Map<String, User> users = new HashMap<>();

    // Create a default user when the application starts
    @PostConstruct
    public void init() {
        User defaultUser = new User();
        defaultUser.setUsername("journal");
        defaultUser.setPassword(passwordEncoder.encode("journal123"));
        defaultUser.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
        users.put(defaultUser.getUsername(), defaultUser);

        System.out.println("===============================================");
        System.out.println("Default user created!");
        System.out.println("Username: journal");
        System.out.println("Password: journal123");
        System.out.println("===============================================");
    }

    // Save a new user
    public User saveUser(User user) {
        // Only encode password if it's a new user or password has changed
        User existingUser = users.get(user.getUsername());
        if (existingUser == null || !user.getPassword().equals(existingUser.getPassword())) {
            // Only encode if password doesn't start with BCrypt encoding prefix
            if (!user.getPassword().startsWith("$2a$")) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
        }
        users.put(user.getUsername(), user);
        return user;
    }

    // Find user by username
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    // Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // Delete user by username
    public void deleteByUsername(String username) {
        users.remove(username);
    }

    // Update user
    public User updateUser(String username, User user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user.setUsername(username);
        users.put(username, user);
        return user;
    }
}

