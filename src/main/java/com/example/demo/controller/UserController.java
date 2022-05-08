package com.example.demo.controller;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @GetMapping("/users")
    public List<User> listAll() {
        return userService.findAll();
    }

    @PreAuthorize("@userSecurity.hasUserId(authentication,#userId)")
    @GetMapping("/users/{userId}")
    public User getOne(@PathVariable(value = "userId") Long userId) {
        return userService.findById(userId);
    }

    @PostMapping("/signup")
    public User save(@RequestBody UserDAO user) {
        return userService.save(user);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/user/manager/{userId}")
    public Void deleteManager(@PathVariable(value = "userId") Long userId) {
        userService.delete(userId);
        return null;
    }

    @PreAuthorize("@userSecurity.adminDeleting(authentication,#userId)")
    @DeleteMapping("/user/admin/{userId}")
    public Void deleteAdmin(@PathVariable(value = "userId") Long userId) {
        userService.delete(userId);
        return null;
    }
}
