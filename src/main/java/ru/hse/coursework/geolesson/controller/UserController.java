package ru.hse.coursework.geolesson.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hse.coursework.geolesson.model.Account;
import ru.hse.coursework.geolesson.service.UserService;

import java.util.List;

@Controller
@RequestMapping("users")
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<Account> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/signUp")
    public String addUser(@ModelAttribute Account user) {
        user.setRoles("ROLE_USER");
        userService.addUser(user);
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "signUp";
    }
}
